/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycafe_Banhang;

import quanlycafe_Banhang.JpGoiMon;
import quanlycafe_Banhang.BanHang;
import Models.Ban;
import Models.ChiTietHD;
import Models.HoaDon;
import Models.ThucDon;
import Sql_and_library.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author ThangIKCU
 */
public class DLSoLuong extends javax.swing.JDialog {
   Mysql cn = new Mysql();
   Connection conn = cn.getConnection();
    int sl = 0;
    ArrayList<ThucDon> arrThucDon;
    public String gioden, mamon, TenBan;
    public int maban;
    ChiTietHD mon;
    private int soLuongmon;
    private boolean a = true;
    public ImageIcon icon =new ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_java_100px_1.png"));
    /**
     * Creates new form NewJDialog
     */
    
    /**
     * Creates new form NewJDialog
     * @param parent
     * @param modal
     * @param MaMon
     * @param tenban
     * @param MaBan
     */
    public DLSoLuong(java.awt.Frame parent, boolean modal, String MaMon, String tenban, int MaBan) {
        super(parent, modal);
        initComponents();
        mamon = MaMon;
        TenBan = tenban;
        maban = MaBan;
        Fill();
        mon = cn.GetDsChiTiet(MaMon, MaBan);
        if(mon != null){
            txtgia.setText(String.valueOf(mon.GetGia()));
            txtSl.setText(String.valueOf(mon.GetSoLuong()));
            soLuongmon = mon.GetSoLuong();
        }
        JRootPane rp = this.getRootPane();
        rp.setDefaultButton(jButton1);
                

    }
    private void Fill(){
        arrThucDon = cn.GetThucDonByMa(mamon);
        txtSl.setText("1");
        lblban.setText(TenBan + " ");
        
        lblTenMon.setText(arrThucDon.get(0).GetTenMon());
        lblDVT.setText(arrThucDon.get(0).GetDVT());
        txtgia.setText(String.valueOf(arrThucDon.get(0).GetDonGia()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTenMon = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        txtSl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblban = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(140, 140, 6));
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(95, 164, 154));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        lblTenMon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTenMon.setForeground(new java.awt.Color(51, 0, 0));
        lblTenMon.setText("Cà phê sữa");

        lblDVT.setText("Ly");

        txtSl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSlKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Đồng ý");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/minus.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/plus_1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Số lượng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Giá:");

        lblban.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblban.setForeground(new java.awt.Color(0, 51, 0));
        lblban.setText("Bàn1");

        txtgia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtgiaKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_java_100px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblban))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTenMon)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblban)
                    .addComponent(lblTenMon))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDVT)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            sl = Integer.parseInt(txtSl.getText());
            if(sl < 30){
                sl++;
                txtSl.setText(String.valueOf(sl));
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            sl = Integer.parseInt(txtSl.getText());
            if(sl != 1 && sl != 0){
                sl--;
                txtSl.setText(String.valueOf(sl));
            }
        }catch(Exception e){
                txtSl.setText("1");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(cn.GetMaHD(maban) == 0){
            HoaDon hd = new HoaDon();
            hd.SetMaBan(maban);
            hd.SetTrangThai(0);
            //JOptionPane.showMessageDialog(null, gioden);
            int insertHd = cn.InsertHoaDon(hd, gioden);
        }
        if(mon != null){
            ChiTietHD ct = new ChiTietHD();
            ct.SetGia(Integer.parseInt(txtgia.getText()));
            try{
            String selectSL = "Select * From tblthucdon Where MaMon = '"+mamon+"' ";
            PreparedStatement ps = conn.prepareStatement(selectSL);
            ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    if(Integer.parseInt(txtSl.getText())<= rs.getInt("SoLuong")){
                        if(Integer.parseInt(txtSl.getText())<soLuongmon){
                            String congsoluong = "Update tblthucdon set SoLuong ='"+(rs.getInt("SoLuong")+(soLuongmon-Integer.parseInt(txtSl.getText())))+"' Where MaMon = '"+mamon+"'";
                            PreparedStatement ps1 = conn.prepareStatement(congsoluong);
                            ps1.execute();
                        }
                        else if(Integer.parseInt(txtSl.getText())>soLuongmon){
                            String trusoluong = "Update tblthucdon set SoLuong ='"+(rs.getInt("SoLuong")-(Integer.parseInt(txtSl.getText())-soLuongmon))+"' Where MaMon = '"+mamon+"'";
                            PreparedStatement ps1 = conn.prepareStatement(trusoluong);
                            ps1.execute();
                        }
                        a=true;
                        ct.SetSoLuong(Integer.parseInt(txtSl.getText()));
                    }else{
                        JOptionPane.showMessageDialog(null,"Số lượng món này trong kho không đủ!",null,JOptionPane.INFORMATION_MESSAGE,icon);
                        a= false;
                    }
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Lỗi!",null,JOptionPane.INFORMATION_MESSAGE,icon);
                a= false;
            }
            ct.SetMaChiTietHD(mon.GetMaChiTietHD());
            int updatect = cn.UpdateChiTiet(ct);
        }if(mon == null){
            ChiTietHD cthd = new ChiTietHD();
            cthd.SetGia(Integer.parseInt(txtgia.getText()));
            cthd.SetMaHD(cn.GetMaHD(maban));
            cthd.SetMaMon(mamon);
            try{
            String selectSL = "Select * From tblthucdon Where MaMon = '"+mamon+"' ";
            PreparedStatement ps = conn.prepareStatement(selectSL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(Integer.parseInt(txtSl.getText())<= rs.getInt("SoLuong")){
                    cthd.SetSoLuong(Integer.parseInt(txtSl.getText()));
                    String trusoluong = "Update tblthucdon set SoLuong ='"+(rs.getInt("SoLuong")-Integer.parseInt(txtSl.getText()))+"' Where MaMon = '"+mamon+"'";
                    PreparedStatement ps1 = conn.prepareStatement(trusoluong);
                    ps1.execute();
                    int isertCtHD = cn.InsertChiTietHD(cthd);
                    a=true;
                }else{
                  JOptionPane.showMessageDialog(null,"Số lượng món này trong kho không đủ!",null,JOptionPane.INFORMATION_MESSAGE,icon);
                    a= false;  
                }
            }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Lỗi!",null,JOptionPane.INFORMATION_MESSAGE,icon);
                a= false;
            }
            
        }
        if(a==true){
            Ban b = new Ban();
            b.SetTrangThai("Đang phục vụ");
            b.SetTenBan(TenBan);
            b.SetMaBan(maban);
            int updateban = cn.UpdateBan(b);

            BanHang.bh.taoBan();
    //        BanHang.bh.updateUI();
            JpGoiMon.gm.fillDsMon(cn.GetMaHD(maban));
            JpGoiMon.gm.updateUI();

            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSlKeyReleased
        try{
            sl = Integer.parseInt(txtSl.getText());
            if(txtSl.getText().equals("0"))
                txtSl.setText("1");
        }catch(Exception e){
           txtSl.setText("1");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlKeyReleased

    private void txtgiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtgiaKeyReleased
        try{
            Integer.parseInt(txtgia.getText());

        }catch(Exception e){
            txtgia.setText(String.valueOf(arrThucDon.get(0).GetDonGia()));
        }
        if(txtgia.getText().equals("0")){
            txtgia.setText(String.valueOf(arrThucDon.get(0).GetDonGia()));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiaKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JLabel lblban;
    private javax.swing.JTextField txtSl;
    private javax.swing.JTextField txtgia;
    // End of variables declaration//GEN-END:variables
}
