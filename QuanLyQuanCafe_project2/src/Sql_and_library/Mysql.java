/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql_and_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Models.Ban;
import Models.ChiTietHD;
import Models.DsOrder;
import Models.HoaDon;
import Models.Loai;
import Models.ThucDon;

/**
 *
 * @author Dell
 */
public class Mysql {
        public Connection conn;
        public static Connection getConnection(){
            Connection connection = null;
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycaphenew?serverTimezone=Asia/Bangkok", "root", "");
            return connection;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }  
        public Mysql(){
            try{
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycaphenew?serverTimezone=Asia/Bangkok", "root", "");
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Kết nối thất bại !");
           }  
        }
        public ArrayList<ThucDon> GetThucDon(String ma){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        if(ma == null){
            sql = "Select * From thucdon";
        }else{
            sql = "Select * From thucdon Where MaLoai = '"+ma+"'";
        }
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;        
    }
        public ArrayList<Loai> GetLoai(){
        ArrayList<Loai> arrloai = null;
        String sql = "Select * From nhommon";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new ArrayList<Loai>();
            while(rs.next()){
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai; 
    }
    public int UpDateTrangThaiBan(Ban b){
         int update = 0;
        String sql = "UPDATE ban SET TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
        try{
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;        
    }
    public int UpdateChiTiet(ChiTietHD ct){
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '"+ct.GetSoLuong()+"', Gia = '"+ct.GetGia()+"' WHERE MaChiTietHD = '"+ct.GetMaChiTietHD()+"'";
        try{
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;        
    }
    public int InsertHoaDon(HoaDon hd, String gio){
        int insert = 0;
        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('"+hd.GetMaBan()+"', '"+gio+"', '"+hd.GetTrangThai()+"')";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    public int ThanhToan(HoaDon hd){
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '"+hd.GetTongTien()+"', TrangThai = 1 WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    }
    public int HuyHD(HoaDon hd){
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    }   
    public ArrayList<Ban> GetBan(int maban){
        ArrayList<Ban> arrBan = null;
        String sql;
        if(maban == 0)
            sql = "Select * From ban";
        else
            sql = "Select * From ban Where maBan = '"+maban+"'";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while(rs.next()){
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan; 
    } 
    public int DeleteMon(String mamon, int mahd, int maban){
        int check = 0;
        try{
            String sql;
            sql = "Delete From chitiethd Where MaMon = '"+mamon+"' AND MaHoaDon = '"+mahd+"'";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if(CheckDsMon(mahd, maban) == 0){
                check = 2;
            }
        }catch(SQLException ex){

        }
        return check;
    }
    public int CheckDsMon(int mahd, int maban){
        String sql;
        int dem = 0;
            sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '"+maban+"' AND ct.MaHoaDon = '"+mahd+"' AND TrangThai = 0";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dem++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;        
    }   
    public int UpdateBan(Ban b){
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '"+b.GetTenBan()+"', TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
        try{
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }
    public String GetMaLoai(String TenLoai){
        String maloai = null;
        String sql = "Select MaLoai From nhommon Where TenLoai = '"+TenLoai+"'";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                maloai = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã loại !");
        }
        return maloai; 
    }
    public ArrayList<ThucDon> GetThucDonByMa(String ma){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;

            sql = "Select * From thucdon Where MaMon = '"+ma+"'";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;        
    }
     public ArrayList<DsOrder> GetDsOrder(int ma){
        ArrayList<DsOrder> arrDs = null;
        String sql;
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '"+ma+"'";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;        
    }   
    public ChiTietHD GetDsChiTiet(String ma, int maban){
        ChiTietHD arrDs = null;
        String sql;

            sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '"+ma+"' AND MaBan = '"+maban+"' AND hd.TrangThai = 0";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                arrDs = new ChiTietHD();
                arrDs.SetSoLuong(rs.getInt(1));
                arrDs.SetGia(rs.getInt(2));
                arrDs.SetMaChiTietHD(rs.getInt(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;        
    } 
    public HoaDon GetHDbyMaBan(int ma){
        String sql;
        HoaDon arrhd = null;
            sql = "Select * From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
//                System.out.println(rs.getTimestamp(4));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;        
    }    
    public int GetMaHD(int ma){
        String sql;
        int mahd = 0;
            sql = "Select MaHoaDon From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mahd = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;        
    } 
    public int UpdateHD(HoaDon hd){
        int update = 0;
        String sql = "UPDATE hoadon SET GiamGia = '"+hd.GetGiamGia()+"' WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = conn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Giảm giá không thành công !");
        }
        return update;
    }    
    public int InsertChiTietHD(ChiTietHD cthd){
        int insert = 0;
        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('"+cthd.GetMaHD()+"', '"+cthd.GetMaMon()+"', '"+cthd.GetSoLuong()+"', '"+cthd.GetGia()+"')";
        try{
            Statement st = conn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !"+ex.toString());
        }
        return insert;
    }
}

