/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Sql_and_library.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Hoang Quan
 */
public class DatBan extends javax.swing.JFrame {
    private Detail detail;
    private String sql="SELECT * FROM datban ORDER BY ban ASC";
    boolean add =false;
    boolean change= false;
    public DatBan(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        detail=new Detail(d);
        Disabled();
        Connection conn = Mysql.getConnection();
        loadBan();
        Load(sql);
    }
    private void Load(String sql){
        try{
            String[] arry={"Tên khách hàng","SĐT","Bàn","Thời gian","Ngày","Thanh toán","Ghi Chú"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getString("tenKH").trim());
                vector.add(rs.getString("sdt").trim());
                vector.add(rs.getInt("ban"));
                vector.add(rs.getString("thoiGian").trim());
                vector.add(rs.getString("ngay").trim());
                vector.add(rs.getString("thanhToan").trim());
                vector.add(rs.getString("ghiChu").trim());
                model.addRow(vector);
            }
            tbDatban.setModel(model);
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void reset(){
        loadBan();
        loadHours();
        loadMinute();
        tfTenkhach.setText("");
        tfSDT.setText("");
        cboSoban.setSelectedIndex(0);
        cbxHours.setSelectedIndex(0);
        cbxMinute.setSelectedIndex(0);
        ((JTextField)tfDay.getDateEditor().getUiComponent()).setText("");
        rd_NO.setSelected(false);
        radDathanhtoan.setSelected(false);
        tfNote.setText("");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnExit.setEnabled(false);
        lbTrangthai.setText("Trạng thái");  
    }
    private boolean checkNull(){
        if(tfTenkhach.getText().equals(""))
        {
         lbTrangthai.setText("Bạn chưa nhập tên khách hàng");
         return false;
        }else
         if(tfSDT.getText().equals("")){
            lbTrangthai.setText("Bạn cần phải nhập số điện thoại của khách");
            return false;
        }else
         if(cboSoban.getSelectedItem()== null){
            lbTrangthai.setText("Bạn cần chọn bàn cho khách");
            return false;
        }else
//         if(tfTimes.getText().equals("")){
//            lbTrangthai.setText("Chưa có thời gian đặt bàn của khách");
//            return false;
//        }else
         if(((JTextField)tfDay.getDateEditor().getUiComponent()).getText().equals("")){
            lbTrangthai.setText("Chưa ấn định ngày đặt bàn");
            return false;
        }else
         if(rd_NO.isSelected()==false && radDathanhtoan.isSelected()==false){
            lbTrangthai.setText("Bạn chưa chọn tình trạng thanh toán!");
            return false;
        }
        return true;
    }
    
    private void Enabled(){
        tfTenkhach.setEnabled(true);
        tfSDT.setEnabled(true);
        cboSoban.setEnabled(true);
        cbxHours.setEnabled(true);
        cbxMinute.setEnabled(true);
        tfDay.setEnabled(true);
        rd_NO.setEnabled(true);
        radDathanhtoan.setEnabled(true);
        tfNote.setEnabled(true);
    }
    
    private void Disabled(){
        tfTenkhach.setEnabled(false);
        tfSDT.setEnabled(false);
        cboSoban.setEnabled(false);
        cbxHours.setEnabled(false);
        cbxMinute.setEnabled(false);
        tfDay.setEnabled(false);
        rd_NO.setEnabled(false);
        radDathanhtoan.setEnabled(false);
        tfNote.setEnabled(false);
    }
    
    private String thanhtoan(){
        if(rd_NO.isSelected()){
            return rd_NO.getText();
        }else
            return radDathanhtoan.getText();
    }
    
    private void checkThanhtoan(String tt){
        if(tt.equals("Không")){
            rd_NO.setSelected(true);
        }else
            radDathanhtoan.setSelected(true);
    }
    
    private void loadBan(){
        cboSoban.removeAllItems();
         
        for(int i=1;i <= 25;i++){
            cboSoban.addItem(String.valueOf(i));
        }
    }
    
    private void loadHours(){
        cbxHours.removeAllItems();
        
        for(int i=0;i <= 23;i++){
            cbxHours.addItem(String.valueOf(i));
        }
    }
    
    private void loadMinute(){
        cbxMinute.removeAllItems();
        
        for(int i=0;i <= 59;i++){
            if(i<10){
                cbxMinute.addItem(String.valueOf("0"+i));
            }
            else cbxMinute.addItem(String.valueOf(i));
        }
    }
    
    private void addCustomer(){
        if(checkNull()){
            String sqladd = "INSERT INTO datban (tenKH,sdt,ban,thoiGian,ngay,thanhToan,ghiChu) VALUES (N'"+tfTenkhach.getText()+"',N'"+tfSDT.getText()+"',"+cboSoban.getSelectedItem()+",'"+cbxHours.getSelectedItem()+lbl2Cham.getText()+cbxMinute.getSelectedItem()+"','"+((JTextField)tfDay.getDateEditor().getUiComponent()).getText()+"','"+thanhtoan()+"',N'"+this.tfNote.getText()+"')";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqladd);
                ps.execute();
                lbTrangthai.setText("Đã thêm thành công khách hàng " +tfTenkhach.getText());
                reset();
                Load(sql);
                Disabled();
            } catch (SQLException ex) {
                Logger.getLogger(DatBan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private void editCustomer(){
        if(checkNull()){
            int click=tbDatban.getSelectedRow();
            TableModel model=tbDatban.getModel();
            String sqlChange="UPDATE datban SET tenKH=N'"+tfTenkhach.getText()+"', sdt='"+tfSDT.getText()+"', thanhToan=N'"+thanhtoan()+"',ban="+cboSoban.getSelectedItem()+", thoiGian='"+cbxHours.getSelectedItem()+lbl2Cham.getText()+cbxMinute.getSelectedItem()+"', ngay='"+((JTextField)tfDay.getDateEditor().getUiComponent()).getText()+"', ghiChu=N'"+this.tfNote.getText()+"' WHERE sdt=N'"+model.getValueAt(click, 1)+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlChange);
                ps.execute();
                reset();
                Load(sql);
                Disabled();
                lbTrangthai.setText("Sửa thông tin khách hàng thành công!");
            } catch (SQLException ex) {
                Logger.getLogger(DatBan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean check(){
        try {
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("sdt").toString().trim().equals(tfSDT.getText())){
                    lbTrangthai.setText("Khách hàng đã tồn tại");
                    return false;
                }  
            }
            rs.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        traTruoc = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb_tenKH = new javax.swing.JLabel();
        lb_sdtKH = new javax.swing.JLabel();
        lb_Bando = new javax.swing.JLabel();
        lb_time = new javax.swing.JLabel();
        lb_days = new javax.swing.JLabel();
        lb_traTruoc = new javax.swing.JLabel();
        tfTenkhach = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        cboSoban = new javax.swing.JComboBox<>();
        rd_NO = new javax.swing.JRadioButton();
        radDathanhtoan = new javax.swing.JRadioButton();
        cbxHours = new javax.swing.JComboBox<>();
        cbxMinute = new javax.swing.JComboBox<>();
        lbl2Cham = new javax.swing.JLabel();
        tfDay = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatban = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();
        lb_ghiChuKH = new javax.swing.JLabel();
        tfNote = new javax.swing.JTextField();
        btn_home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐẶT BÀN");

        lb_tenKH.setText("Tên khách hàng:");

        lb_sdtKH.setText("Số điện thoại:");

        lb_Bando.setText("Bàn số:");

        lb_time.setText("Thời gian:");

        lb_days.setText("Ngày:");

        lb_traTruoc.setText("Trả trước:");

        tfSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSDTActionPerformed(evt);
            }
        });
        tfSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSDTKeyReleased(evt);
            }
        });

        cboSoban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSobanActionPerformed(evt);
            }
        });

        traTruoc.add(rd_NO);
        rd_NO.setText("Không");
        rd_NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_NOActionPerformed(evt);
            }
        });

        traTruoc.add(radDathanhtoan);
        radDathanhtoan.setText("Đã thanh toán");
        radDathanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radDathanhtoanActionPerformed(evt);
            }
        });

        cbxHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giờ" }));

        cbxMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phút" }));

        lbl2Cham.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl2Cham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2Cham.setText(":");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_traTruoc)
                    .addComponent(lb_sdtKH)
                    .addComponent(lb_tenKH)
                    .addComponent(lb_Bando)
                    .addComponent(lb_time)
                    .addComponent(lb_days))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTenkhach)
                    .addComponent(tfSDT)
                    .addComponent(cboSoban, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rd_NO, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radDathanhtoan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxHours, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl2Cham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tenKH)
                    .addComponent(tfTenkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_sdtKH)
                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Bando)
                    .addComponent(cboSoban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_time)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl2Cham)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_days)
                    .addComponent(tfDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_traTruoc)
                    .addComponent(rd_NO)
                    .addComponent(radDathanhtoan))
                .addContainerGap())
        );

        tbDatban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbDatban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatbanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDatban);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/plus.png"))); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 50));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/edit.png"))); // NOI18N
        btnEdit.setPreferredSize(new java.awt.Dimension(100, 50));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/delete.png"))); // NOI18N
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 50));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/floppy-disk (1).png"))); // NOI18N
        btnSave.setPreferredSize(new java.awt.Dimension(100, 50));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/x-button.png"))); // NOI18N
        btnExit.setPreferredSize(new java.awt.Dimension(100, 50));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setPreferredSize(new java.awt.Dimension(51, 20));

        lb_ghiChuKH.setText("Ghi chú");

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/home.png"))); // NOI18N
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_ghiChuKH)
                            .addComponent(tfNote, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_home)
                        .addGap(65, 65, 65)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_ghiChuKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNote))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSDTActionPerformed

    private void cboSobanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSobanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSobanActionPerformed

    private void rd_NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_NOActionPerformed
        rd_NO.setSelected(true);
        radDathanhtoan.setSelected(false);
    }//GEN-LAST:event_rd_NOActionPerformed

    private void radDathanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radDathanhtoanActionPerformed
        radDathanhtoan.setSelected(true);
        rd_NO.setSelected(false);
    }//GEN-LAST:event_radDathanhtoanActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(add==true){
            if(check()){
                addCustomer();
            }
        }
        else{
            if(change==true)
                editCustomer();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
        quanlyquancafe_Main  main = new quanlyquancafe_Main(detail);
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        reset();
        add=true;
        Enabled();
        
        btnSave.setEnabled(true);   
        btnAdd.setEnabled(false);
        btnExit.setEnabled(true);
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        loadBan();
        loadHours();
        loadMinute();
        add=false;
        change=true;
        Enabled();
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       btnSave.setEnabled(true); 
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
            String sqlDelete="DELETE FROM datban WHERE sdt=N'"+tfSDT.getText()+"'";
           try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.execute();
                reset();
                Load(sql);
                Disabled();
                lbTrangthai.setText("Xóa thành công khách hàng");
           } catch (SQLException ex) {
               Logger.getLogger(DatBan.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else reset();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbDatbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatbanMouseClicked
        cboSoban.removeAllItems();
        cbxHours.removeAllItems();
        cbxMinute.removeAllItems();
        int click=tbDatban.getSelectedRow();
        TableModel model=tbDatban.getModel();
        tfTenkhach.setText(model.getValueAt(click, 0).toString());
        tfSDT.setText(model.getValueAt(click, 1).toString());
        cboSoban.addItem(model.getValueAt(click, 2).toString());
        String[] s=model.getValueAt(click, 3).toString().split(":");
        cbxHours.addItem(s[0]);
        cbxMinute.addItem(s[1]);
        ((JTextField)tfDay.getDateEditor().getUiComponent()).setText(model.getValueAt(click, 4).toString());
        tfNote.setText(model.getValueAt(click, 6).toString());
        checkThanhtoan(model.getValueAt(click, 5).toString());
        btnEdit.setEnabled(true);
        btnExit.setEnabled(true);
    }//GEN-LAST:event_tbDatbanMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        reset();
        Disabled();
        Load(sql);
    }//GEN-LAST:event_btnExitActionPerformed
    private String cutChar(String arry){
        return arry.replaceAll("\\D+","");
    }
    private void tfSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSDTKeyReleased
       tfSDT.setText(cutChar(tfSDT.getText()));
        
        if(tfSDT.getText().length()==11 || tfSDT.getText().length()==10 ){
            btnSave.setEnabled(true);
            lbTrangthai.setText("Số điện thoại đã hợp lệ!!");
        }
        else
        if(tfSDT.getText().length()>11 || tfSDT.getText().length()<10){
            btnSave.setEnabled(false);
            lbTrangthai.setText("Số điện thoại không được ít hơn 10 số hoặc vượt quá 11 số!!");
        }
    }//GEN-LAST:event_tfSDTKeyReleased

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
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detail detail= new Detail();
                if(detail.getRoll().equals("3")){
                   new DatBan(detail).setVisible(false);
                   Login login = new Login();
                   login.setVisible(true);
                }else{
                new DatBan(detail).setVisible(true);
                }
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_home;
    private javax.swing.JComboBox<String> cboSoban;
    private javax.swing.JComboBox<String> cbxHours;
    private javax.swing.JComboBox<String> cbxMinute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JLabel lb_Bando;
    private javax.swing.JLabel lb_days;
    private javax.swing.JLabel lb_ghiChuKH;
    private javax.swing.JLabel lb_sdtKH;
    private javax.swing.JLabel lb_tenKH;
    private javax.swing.JLabel lb_time;
    private javax.swing.JLabel lb_traTruoc;
    private javax.swing.JLabel lbl2Cham;
    private javax.swing.JRadioButton radDathanhtoan;
    private javax.swing.JRadioButton rd_NO;
    private javax.swing.JTable tbDatban;
    private com.toedter.calendar.JDateChooser tfDay;
    private javax.swing.JTextField tfNote;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTenkhach;
    private javax.swing.ButtonGroup traTruoc;
    // End of variables declaration//GEN-END:variables
}
