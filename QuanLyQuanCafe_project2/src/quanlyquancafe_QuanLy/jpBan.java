/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_QuanLy;

import Models.Ban;
import Models.Detail;
import Sql_and_library.Mysql;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import quanlycafe_Banhang.BanHang;
import quanlycafe_Banhang.Run;

/**
 *
 * @author Hoang Quan
 */
public class jpBan extends javax.swing.JPanel {

    /**
     * Creates new form jpBan
     */
    public static jpBan B;
    private Mysql cn = new Mysql();
    private boolean add = false;
    private boolean change = false;
    private Detail detail;
    private String sql="SELECT * FROM tblban ORDER BY MaBan";
    public jpBan() {
        initComponents();
        setStyle();
//        detail= new Detail(d);
        loadData(sql);
//        Disabled();
        B = this;
    }
//    private void Disabled(){
//        lbMaHH.setEnabled(false);
//        tftenLHH.setEnabled(false);
//    }
//    private void Enabled(){
//        lbMaHH.setEnabled(true);
//        tftenLHH.setEnabled(true);
//    }
//    private void reset(){
//        add=false;
//        change=false;
//        lbMaHH.setText("");
//        tftenLHH.setText("");
//        lbTrangthai.setText("");
//        btnAdd.setEnabled(true);
//        btnSave.setEnabled(false);
//        btnEdit.setEnabled(false);
//        btnDelete.setEnabled(false);
//        btnExit.setEnabled(false);
//    }
    public void loadData(String sql){
       ArrayList<Ban> arrTable = cn.GetBan(0);
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã Bàn");
        tbmodel.addColumn("Tên bàn");
        tbmodel.addColumn("Trạng thái");

        if (arrTable != null) {
            int soban = 0;
            for (Ban b : arrTable) {
                soban++;
                tbmodel.addRow(new Object[]{b.GetMaBan(), b.GetTenBan(), b.GetTrangThai()});
            }
            lblthongtin.setText(String.valueOf(soban)+" bàn");
        } else {
            JOptionPane.showMessageDialog(null, "Không có bàn nào");
        }
        tbBan.setModel(tbmodel);
        for(int i = 0; i < tbBan.getColumnCount();i++){
            Class<?> col = tbBan.getColumnClass(i);
            tbBan.setDefaultEditor(col, null);
        }     
    }
    private void setStyle(){
        tbBan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        tbBan.getTableHeader().setOpaque(false);
        tbBan.getTableHeader().setBackground(new Color(51,107,135));
        tbBan.getTableHeader().setForeground(new Color(51,107,135));
        tbBan.setRowHeight(25);
    }
//    private boolean checkNull(){
//        if(tftenLHH.getText().equals("")){
//            lbTrangthai.setText("Chưa nhập tên bàn");
//            return false;
//        }
//        return true;
//    }
//    private void addLHH(){
//        if(checkNull()){
//            String sqlAdd="INSERT INTO tblban (TenBan,TrangThai) VALUES (N'"+tftenLHH.getText()+"',null)";
//            try {
//                Connection conn = Mysql.getConnection();
//                PreparedStatement ps = conn.prepareStatement(sqlAdd);
//                ps.execute();
//                reset();
//                loadData(sql);
//                Disabled();
//                lbTrangthai.setText("Thêm bàn thành công!");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }   
//        }
//    }
//    private void editLHH(){
//        if(checkNull()){
//            int click=tbBan.getSelectedRow();
//            TableModel model=tbBan.getModel();
//            String sqlAdd="UPDATE tblban SET TenBan = N'"+tftenLHH.getText()+"' WHERE  MaLHH = '"+lbMaHH.getText()+"' ";
//            try {
//                Connection conn = Mysql.getConnection();
//                PreparedStatement ps = conn.prepareStatement(sqlAdd);
//                ps.execute();
//                loadData(sql);
//                Disabled();
//                tbBan.setVisible(true);
//                lbTrangthai.setText("Thay đổi Tên Bàn thành công!");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }   
//        }
//    }
//    private boolean check(){
//        try {
//            Connection conn = Mysql.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                if(rs.getString("TenBan").toString().trim().equals(tftenLHH.getText())){
//                    lbTrangthai.setText("Tên bàn bạn nhập đã tồn tại");
//                    return false;
//                }
//            }
//            rs.close();
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return true;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblthongtin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttim = new javax.swing.JTextField();

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 165, 173));
        kGradientPanel1.setkStartColor(new java.awt.Color(196, 223, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(820, 644));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 107, 135)));

        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbBan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbBan.setRowHeight(25);
        tbBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBan);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_add_48px.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_edit_48px.png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_delete_bin_48px.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 107, 135));
        jLabel1.setText("Bàn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Tổng số bàn:");

        lblthongtin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblthongtin.setForeground(new java.awt.Color(153, 0, 0));
        lblthongtin.setText("Total");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tìm bàn:");

        txttim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimActionPerformed(evt);
            }
        });
        txttim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblthongtin)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(btnAdd)
                        .addGap(33, 33, 33)
                        .addComponent(btnEdit)
                        .addGap(53, 53, 53)
                        .addComponent(btnDelete)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblthongtin))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanMouseClicked
        btnEdit.setEnabled(true);        
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tbBanMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Them_Ban ban = new Them_Ban(Run.QlCafe, true);
        ban.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int select=tbBan.getSelectedRow();
        if(select<0){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bàn nào !");
        }else{
            int MaBan = (int) tbBan.getValueAt(select, 0);
            Sua_Ban sua = new Sua_Ban(Run.QlCafe, true, MaBan);
            sua.setVisible(true);
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int[] selectedRows = tbBan.getSelectedRows();

        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bàn nào !");
        } else {
            ArrayList<Integer> ListMaBan = new ArrayList<Integer>();
            String sp = "";
            for (int i : selectedRows) {
                int ma = (int) tbBan.getValueAt(i, 0);
                ListMaBan.add(ma);
                String tenban = (String) tbBan.getValueAt(i, 1);

                sp += tenban + "\n";
            }
            int qs;
            qs = JOptionPane.showConfirmDialog(null, "Xóa bàn: \n " + sp, "Xóa bàn", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = cn.DeleteBan(ListMaBan);

                if (xoa == true) {
                    jpBan.B.loadData(sql);
                    jpBan.B.updateUI();
                    try{
                        BanHang.bh.taoBan();
                        BanHang.bh.updateUI();
                    }catch(Exception e){
                        
                    }
                }else
                    JOptionPane.showMessageDialog(null, "Không xóa được bàn !");

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txttimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKeyReleased
        ArrayList<Ban> arrTable = cn.SearchBan(txttim.getText());
        if(arrTable != null){
            DefaultTableModel tbmodel = new DefaultTableModel();

            tbmodel.addColumn("Mã Bàn");
            tbmodel.addColumn("Tên bàn");
            tbmodel.addColumn("Trạng thái");

            int soban = 0;
            for (Ban b : arrTable) {
                soban++;
                tbmodel.addRow(new Object[]{b.GetMaBan(), b.GetTenBan(), b.GetTrangThai()});
            }
            lblthongtin.setText(String.valueOf(soban)+" bàn");
            tbBan.setModel(tbmodel);
            for(int i = 0; i < tbBan.getColumnCount();i++){
                Class<?> col = tbBan.getColumnClass(i);
                tbBan.setDefaultEditor(col, null);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimKeyReleased

    private void txttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JLabel lblthongtin;
    private javax.swing.JTable tbBan;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
