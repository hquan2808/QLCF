/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Sql_and_library.Mysql;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Hoang Quan
 */
public class ThongKe extends javax.swing.JFrame {

    /**
     * Creates new form ThongKe
     */
    private Detail detail;
    private String sql="SELECT * FROM thongke";
    private boolean leapYear=false,Year=false,Month=false,Day=false;
    public ThongKe(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        setStyle();
        detail= new Detail(d);
        select_nam.setValue(Double.parseDouble(new SimpleDateFormat("yyyy").format(new java.util.Date())));
        checkYear();
        addDays();
        loadData(sql);
        Refresh();
    }
    private void setStyle(){
        table_ThongKe.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        table_ThongKe.getTableHeader().setOpaque(false);
        table_ThongKe.getTableHeader().setBackground(new Color(51,107,135));
        table_ThongKe.getTableHeader().setForeground(new Color(51,107,135));
        table_ThongKe.setRowHeight(25);
        
    }
    private void Refresh(){
        Year=false;
        Month=false;
        Day=false;
        select_ngay.setEnabled(false);
        select_thang.setEnabled(false);
        select_nam.setEnabled(false);
        select_thang.setSelectedIndex(0);
        select_ngay.setSelectedIndex(0);
    }
    private void chonSearch(){
        Refresh();
        if(rd_nam.isSelected()){
            select_nam.setEnabled(true);
            Year=true;
        }
        else
        if(rd_thang.isSelected()){
            select_thang.setEnabled(true);
            select_nam.setEnabled(true);
            Month=true;
        }
        else
        if(rd_ngay.isSelected()){
            select_ngay.setEnabled(true);
            select_thang.setEnabled(true);
            select_nam.setEnabled(true);
            Day=true;
        } 
    }
    private void loadData(String sql){
        int count=0;
        long tongTien=0;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try{
            String[] arry={"Nhân viên","Thời gian","Ngày","Thời gian","Tổng tiền"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getString("tenNV").trim());
                vector.add(rs.getString("thoiGian").trim());
                vector.add(rs.getString("ngay").trim());
                vector.add(rs.getString("thoiGian").trim());
                vector.add(rs.getString("tongTien").trim()+" VNĐ");
                model.addRow(vector);
                select_NV.addItem(rs.getString("tenNV"));
            }
            table_ThongKe.setModel(model);
            lbHoadon.setText(String.valueOf(count));
            lbTien.setText(formatter.format(tongTien)+" "+"VND");
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void FindDay(){
        int count=0;
        long tongTien=0;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try{
            String[] arry={"Nhân viên","Thời gian","Ngày","Thời gian","Tổng tiền"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            sql = "SELECT * FROM thongke where tenNV like N'%"+select_NV.getSelectedItem().toString()+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (getNV(rs.getString("tenNV")) == select_NV.getSelectedItem().toString()&&getDay(rs.getString("ngay"))==Double.parseDouble(select_ngay.getSelectedItem().toString()) && getMonth(rs.getString("ngay"))==Double.parseDouble(select_thang.getSelectedItem().toString()) && getYear(rs.getString("ngay"))==Double.parseDouble(select_nam.getValue().toString())) {
                    Vector vector=new Vector();
                    vector.add(rs.getString("tenNV").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("ngay").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("tongTien").trim()+" VNĐ");
                    model.addRow(vector);
                }
            }
            table_ThongKe.setModel(model);
            lbHoadon.setText(String.valueOf(count));
            lbTien.setText(formatter.format(tongTien)+" "+"VND");
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void FindMonth(){
        int count=0;
        long tongTien=0;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try{
            String[] arry={"Nhân viên","Thời gian","Ngày","Thời gian","Tổng tiền"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            sql = "SELECT * FROM thongke where tenNV like N'%"+select_NV.getSelectedItem().toString()+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (getMonth(rs.getString("ngay"))==Double.parseDouble(select_thang.getSelectedItem().toString()) && getYear(rs.getString("ngay"))==Double.parseDouble(select_nam.getValue().toString()) && getNV(rs.getString("tenNV")) == select_NV.getSelectedItem().toString()) {
                    Vector vector=new Vector();
                    vector.add(rs.getString("tenNV").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("ngay").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("tongTien").trim()+" VNĐ");
                    model.addRow(vector);
                }
                
            }
            table_ThongKe.setModel(model);
            lbHoadon.setText(String.valueOf(count));
            lbTien.setText(formatter.format(tongTien)+" "+"VND");
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void FindYear(){
        int count=0;
        long tongTien=0;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try{
            String[] arry={"Nhân viên","Thời gian","Ngày","Thời gian","Tổng tiền"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            sql = "SELECT * FROM thongke where tenNV like N'%"+select_NV.getSelectedItem().toString()+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (getYear(rs.getString("ngay"))== Double.parseDouble(select_nam.getValue().toString()) && getNV(rs.getString("tenNV")) == select_NV.getSelectedItem().toString()){
                    Vector vector=new Vector();
                    vector.add(rs.getString("tenNV").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("ngay").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("tongTien").trim()+" VNĐ");
                    model.addRow(vector);
                }
                
            }
            table_ThongKe.setModel(model);
            lbHoadon.setText(String.valueOf(count));
            lbTien.setText(formatter.format(tongTien)+" "+"VND");
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void FindNV(){
        int count=0;
        long tongTien=0;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try{
            String[] arry={"Nhân viên","Thời gian","Ngày","Thời gian","Tổng tiền"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            sql = "SELECT * FROM thongke where tenNV like N'%"+select_NV.getSelectedItem().toString()+"%'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (getNV(rs.getString("tenNV")) == select_NV.getSelectedItem().toString()){
                    Vector vector=new Vector();
                    vector.add(rs.getString("tenNV").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("ngay").trim());
                    vector.add(rs.getString("thoiGian").trim());
                    vector.add(rs.getString("tongTien").trim()+" VNĐ");
                    model.addRow(vector);
                }
                
            }
            table_ThongKe.setModel(model);
            lbHoadon.setText(String.valueOf(count));
            lbTien.setText(formatter.format(tongTien)+" "+"VND");
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private long convertedToNumbers(String s){
        String number="";
        String []array=s.replace(","," ").split("\\s");
        for(String i:array){
            number=number.concat(i);
        }
        return Long.parseLong(number);
    }
    private double getDay(String s){
        String [] arry= s.replace("/"," ").split("\\s");
        return Double.parseDouble(arry[arry.length-3]);
    }
    private double getMonth(String s){
        String [] arry = s.replace("/"," ").split("\\s");
        return Double.parseDouble(arry[arry.length-2]);
    }
    private double getYear(String s){
        String [] arry = s.replace("/"," ").split("\\s");
        return Double.parseDouble(arry[arry.length-1]);
    }
    private String getNV(String string){
        return select_NV.getSelectedItem().toString();
    }
    private void checkYear(){
        if(Double.parseDouble(String.valueOf(select_nam.getValue()))%4==0 && Double.parseDouble(String.valueOf(select_nam.getValue()))%100!=0 || Double.parseDouble(String.valueOf(select_nam.getValue()))%400==0 ){
            leapYear=true;
        }
        else    leapYear=false;
    }
    private void addDays(){
        select_ngay.setEnabled(true);
        String []day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        int q = Integer.parseInt(select_thang.getSelectedItem().toString());
        switch(q){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                select_ngay.removeAllItems();
                for (String i : day) {
                    select_ngay.addItem(i);
                }
                break;
                
            case 4:
            case 6:
            case 9:
            case 11:
                select_ngay.removeAllItems();
                for (int i = 0; i <day.length-1 ; i++) {
                    select_ngay.addItem(day[i]);
                }
                break;
            case 2:
                select_ngay.removeAllItems();
                if (leapYear == true) {
                    for (int i = 0; i < day.length-2; i++) {
                        select_ngay.addItem(day[i]);
                    }
                }else{
                    for (int i = 0; i < day.length-3; i++) {
                        select_ngay.addItem(day[i]);
                    }
                    break;
                }
                
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        select_thang = new javax.swing.JComboBox<>();
        select_NV = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        select_nam = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        lbHoadon = new javax.swing.JLabel();
        lbTien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        select_ngay = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ThongKe = new javax.swing.JTable();
        rd_nam = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rd_ngay = new javax.swing.JRadioButton();
        rd_thang = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_home = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPopupMenu1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenu1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setPreferredSize(new java.awt.Dimension(51, 20));

        select_thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        select_thang.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                select_thangPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        select_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_thangActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_search_48px.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(255, 255, 255));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_available_updates_48px_1.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhân viên:");

        lbHoadon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbHoadon.setForeground(new java.awt.Color(51, 107, 135));

        lbTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTien.setForeground(new java.awt.Color(51, 107, 135));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tổng hóa đơn: ");

        select_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_ngayActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 107, 135)));

        table_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table_ThongKe.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_ThongKe.setRowHeight(25);
        table_ThongKe.setSelectionBackground(new java.awt.Color(51, 107, 135));
        jScrollPane1.setViewportView(table_ThongKe);

        rd_nam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_nam);
        rd_nam.setText("Xem theo năm");
        rd_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_namActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tổng tiền thu về: ");

        rd_ngay.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_ngay);
        rd_ngay.setText("Xem theo ngày");
        rd_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ngayActionPerformed(evt);
            }
        });

        rd_thang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_thang);
        rd_thang.setText("Xem theo tháng");
        rd_thang.setInheritsPopupMenu(true);
        rd_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_thangActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 107, 135));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Thống kê");

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_back_arrow_50px.png"))); // NOI18N
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_home)
                .addGap(420, 420, 420)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_home)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 107, 135));
        jLabel6.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rd_nam)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(select_NV, 0, 185, Short.MAX_VALUE)
                                    .addComponent(select_nam)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_thang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(select_thang, 0, 181, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_ngay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(select_ngay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(766, 766, 766)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(168, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_ngay)
                            .addComponent(select_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_thang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(select_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_nam)
                            .addComponent(select_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(select_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(lbHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(415, 415, 415)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(257, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_ngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_select_ngayActionPerformed

    private void rd_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ngayActionPerformed
        // TODO add your handling code here:
        chonSearch();
    }//GEN-LAST:event_rd_ngayActionPerformed

    private void rd_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_thangActionPerformed
        // TODO add your handling code here:
        chonSearch();
    }//GEN-LAST:event_rd_thangActionPerformed

    private void rd_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_namActionPerformed
        // TODO add your handling code here:
        chonSearch();
    }//GEN-LAST:event_rd_namActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void jPopupMenu1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenu1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jPopupMenu1PopupMenuWillBecomeInvisible

    private void select_thangPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_select_thangPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        checkYear();
        if(Day == true) addDays();
        else return;
    }//GEN-LAST:event_select_thangPopupMenuWillBecomeInvisible

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
//            String sql = "SELECT * FROM thongke where tenNV like N'%"+select_NV.getSelectedItem().toString()+"%'";
            FindNV();
            if(Day==true){
                FindDay();
            }
            else
            if(Month==true){
                FindMonth();
            }
            else
            if(Year==true){
                FindYear();
            }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void select_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_thangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_select_thangActionPerformed

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
        quanlyquancafe_Main home = new quanlyquancafe_Main(detail);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btn_homeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detail detail= new Detail();
//                if(detail.getRoll().equals("3")){
//                   new ThongKe(detail).setVisible(false);
//                   Login login = new Login();
//                   login.setVisible(true);
//                }else{
                new ThongKe(detail).setVisible(true);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel btn_home;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHoadon;
    private javax.swing.JLabel lbTien;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_ngay;
    private javax.swing.JRadioButton rd_thang;
    private javax.swing.JComboBox<String> select_NV;
    private javax.swing.JSpinner select_nam;
    private javax.swing.JComboBox<String> select_ngay;
    private javax.swing.JComboBox<String> select_thang;
    private javax.swing.JTable table_ThongKe;
    // End of variables declaration//GEN-END:variables
}
