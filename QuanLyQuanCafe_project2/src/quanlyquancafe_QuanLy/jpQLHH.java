/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_QuanLy;
import Models.Detail;
import Models.Loai;
import Models.ThucDon;
import Sql_and_library.Mysql;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import quanlycafe_Banhang.jpThucDon;
import quanlycafe_Banhang.Run;
/**
 *
 * @author Hoang Quan
 */
public class jpQLHH extends javax.swing.JPanel {
    boolean add = false;
    boolean change = false;
    private Detail detail;
    private Mysql cn = new Mysql();
    public static jpQLHH td;
    private String sql="SELECT * FROM tblthucdon INNER JOIN tblnhommon ON tblnhommon.MaLoai = tblthucdon.MaLoai ";
    
    /**
     * Creates new form QLHH
     */
    public jpQLHH() {
        initComponents();
        setStyle();
        loadData(sql);
        Fillcbb();
//        loadLoaiNuoc();
    }
    private void setStyle(){
//        lbText.setBackground(new java.awt.Color(0,0,0,0));
//        tfDonvi.setBackground(new java.awt.Color(0,0,0,0));
//        tfFind.setBackground(new java.awt.Color(0,0,0,0));
//        tfGia.setBackground(new java.awt.Color(0,0,0,0));
//        tfSoluong.setBackground(new java.awt.Color(0,0,0,0));
//        tfTen.setBackground(new java.awt.Color(0,0,0,0));
        tbThucDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        tbThucDon.getTableHeader().setOpaque(false);
        tbThucDon.getTableHeader().setBackground(new Color(51,107,135));
        tbThucDon.getTableHeader().setForeground(new Color(51,107,135));
        tbThucDon.setRowHeight(25);
        
    }
//    private void Disabled(){
//        lbText.setEnabled(false);
//        cbLoai.setEnabled(false);
//        tfTen.setEnabled(false);
//        tfDonvi.setEnabled(false);
//        tfSoluong.setEnabled(false);
//        tfGia.setEnabled(false);
//    }
//    private void Enabled(){
//        lbText.setEnabled(true);
//        cbLoai.setEnabled(true);
//        tfTen.setEnabled(true);
//        tfDonvi.setEnabled(true);
//        tfSoluong.setEnabled(true);
//        tfGia.setEnabled(true);
//    }
//    private void loadLoaiNuoc(){
//        String sql_LHH = "SELECT * FROM tblnhommon ";
//        cbLoai.removeAllItems();
//        try {
//            Connection conn = Mysql.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql_LHH);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                cbLoai.addItem(rs.getString("TenLoai"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(jpQLHH.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//    }
    public void Fillcbb() {
        Vector Vcbb = cn.GetNhomMon();

        if (Vcbb != null) {
            DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel(Vcbb);
            cbbNhomMon.setModel(cbbmodel);
        } else {
            JOptionPane.showMessageDialog(null, "Không có nhóm nào !");
        }

    } 
    public void loadData(String sql){
        try{
            String[] arry={"Mã Món","Tên Món","Mã Loại","Giá Bán","Đơn Vị"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int somon=0;
            while(rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getString("MaMon").trim());
                vector.add(rs.getString("TenMon").trim());
                vector.add(rs.getString("tblnhommon.TenLoai").trim());
                vector.add(rs.getString("DonGia").trim());
                vector.add(rs.getString("DVT").trim());
//                vector.add(rs.getInt("SoLuong"));
                model.addRow(vector);
                somon++;
            }
            soluong.setText(String.valueOf(somon)+" Món");
            tbThucDon.setModel(model);
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
//    private double convertedToNumbers(String s){
//        String number="";
//        String []array=s.replace(","," ").split("\\s");
//        for(String i:array){
//            number=number.concat(i);
//        }
//        return Double.parseDouble(number);
//    }
//    private void reset(){
//        add=false;
//        change=false;
//        loadLoaiNuoc();
//        lbText.setText("");
//        cbLoai.setSelectedIndex(0);
//        tfTen.setText("");
//        tfDonvi.setText("");
//        tfSoluong.setText("");
//        tfGia.setText("");
//        lbTrangthai.setText("Trạng Thái");
//        btnAdd.setEnabled(true);
//        btnSave.setEnabled(false);
//        btnEdit.setEnabled(false);
//        btnDelete.setEnabled(false);
//        btnExit.setEnabled(false);
//    }
//    
//    private void checkKyTu(String arry){
//        char[] character=arry.toCharArray();
//        for(int i = 0; i<character.length;i++){
//            if(String.valueOf(character[i]).matches("\\D+")){
//                btnSave.setEnabled(false);
//                lbTrangthai.setText("Số lượng không thể chứa kí tự");
//                break;
//            }
//            else btnSave.setEnabled(true);
//        }
//    }
//    private boolean checkNull(){
//        if(cbLoai.getSelectedItem().equals("")){
//            lbTrangthai.setText("Bạn chưa chọn loại thức uống!");
//            return false;
//        }
//        else
//        if(tfTen.getText().equals("")){
//            lbTrangthai.setText("Bạn chưa nhập tên thức uống");
//            return false;
//        }
//        else   
//        if(tfDonvi.getText().equals("")){
//            lbTrangthai.setText("Bạn chưa nhập đơn vị tính!");
//            return false;
//        }
//        else   
//        if(tfSoluong.getText().equals("")){
//            lbTrangthai.setText("Bạn chưa nhập số lượng nước!");
//            return false;
//        }
//        else   
//        if(tfGia.getText().equals("")){
//            lbTrangthai.setText("Bạn chưa nhập giá!");
//            return false;
//        }
//        return true;
//    }
//    private String cutChar(String arry){
//        return arry.replaceAll("\\D+","");
//    }
//    
//    private String cutNumber(String arry){
//        return arry.replaceAll("\\d+","");
//    }
//    private void addDrink(){
//        if(checkNull()){
//            String sqlAdd="INSERT INTO tblthucdon (MamMon,TenHH,GiaSP,donVi,SoLuong) VALUES (N'"+cbLoai.getSelectedIndex()+"',N'"+tfTen.getText()+"',N'"+(tfGia.getText().replace(",",""))+"',N'"+tfDonvi.getText()+"',"+tfSoluong.getText()+")";
//            try {
//                Connection conn = Mysql.getConnection();
//                PreparedStatement ps = conn.prepareStatement(sqlAdd);
//                ps.execute();
//                reset();
//                loadData(sql);
//                Disabled();
//                lbTrangthai.setText("Thêm thức uống thành công!");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }   
//        }
//    }
//    private void editDrink(){
//         if(checkNull()){
//            int click=tbThucDon.getSelectedRow();
//            TableModel model=tbThucDon.getModel();
//            String sqlChange="UPDATE tblthucdon INNER JOIN tblnhommon ON tblthucdon.MaLoai = tblthucdon.MaLoai SET  tblthucdon.TenMon=N'"+cbLoai.getSelectedItem()+"', tblthucdon.TenHH=N'"+tfTen.getText()+"', tblthucdon.GiaSP='"+(tfGia.getText().replace(",",""))+"', tblthucdon.donVi='"+tfDonvi.getText()+"',tblthucdon.SoLuong="+tfSoluong.getText()+" WHERE tblthucdon.MaMon=N'"+model.getValueAt(click, 0)+"'";
//            try {
//                Connection conn = Mysql.getConnection();
//                PreparedStatement ps = conn.prepareStatement(sqlChange);
//                ps.execute();
//                reset();
//                loadData(sql);
//                loadLoaiNuoc();
//                Disabled();
//                lbTrangthai.setText("Thay đổi thông tin thành công!");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } 
//        }
//     }
//    private boolean check(){
//        try {
//            Connection conn = Mysql.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                if(rs.getString("TenHH").toString().trim().equals(tfTen.getText())){
//                    lbTrangthai.setText("Thức uống bạn nhập đã tồn tại");
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

        jPanel4 = new javax.swing.JPanel();
        tfFind = new javax.swing.JTextField();
        spDU = new javax.swing.JScrollPane();
        tbThucDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        soluong = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbNhomMon = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(820, 540));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(900, 530));

        tfFind.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfFind.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFindActionPerformed(evt);
            }
        });
        tfFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFindKeyReleased(evt);
            }
        });

        spDU.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 107, 135)));

        tbThucDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbThucDon.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbThucDon.setRowHeight(25);
        tbThucDon.setSelectionBackground(new java.awt.Color(51, 107, 135));
        tbThucDon.setShowVerticalLines(false);
        tbThucDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThucDonMouseClicked(evt);
            }
        });
        spDU.setViewportView(tbThucDon);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tìm món:");

        jLabel3.setBackground(new java.awt.Color(109, 109, 109));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Đồ Uống");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/plus.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/edit.png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/delete.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tổng món");

        soluong.setForeground(new java.awt.Color(255, 51, 51));
        soluong.setText("Sô lượng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 0));
        jLabel4.setText("Nhóm món:");

        cbbNhomMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNhomMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNhomMonItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spDU)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete)
                            .addComponent(btnAdd)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(64, 64, 64)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(cbbNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spDU, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 269, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Them_ThucDon td = new Them_ThucDon(Run.QlCafe, true);
        td.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int[] selectedRows = tbThucDon.getSelectedRows();

        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn món nào !");
        } else {
            ArrayList<String> ListMaBan = new ArrayList<String>();
            String sp = "";
            for (int i : selectedRows) {
                String ma = (String) tbThucDon.getValueAt(i, 0);
                ListMaBan.add(ma);
                String tenban = (String) tbThucDon.getValueAt(i, 1);

                sp += tenban + "\n";
            }
            int qs;
            qs = JOptionPane.showConfirmDialog(null, "Xóa món: \n " + sp, "Xóa món", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = cn.DeleteThucDon(ListMaBan);
                if (xoa == true) {
                    loadData(null);
                    try{
                        jpThucDon.td.FillLoai();
                        jpThucDon.td.updateUI();
                    }catch(Exception e){

                    }
                }else
                    JOptionPane.showMessageDialog(null, "Không xóa được món !");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
         int select=tbThucDon.getSelectedRow();
        if(select<0){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn món nào !");
        }else{
            String mamon = (String) tbThucDon.getValueAt(select, 0);
            Sua_ThucDon sua = new Sua_ThucDon(Run.QlCafe, true, mamon);
            sua.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tbThucDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThucDonMouseClicked
//        cbLoai.removeAllItems();
//        int click=tbThucDon.getSelectedRow();
//        TableModel model=tbThucDon.getModel();
//
//        lbText.setText(model.getValueAt(click, 0).toString());
//        cbLoai.addItem(model.getValueAt(click, 1).toString());
//        tfTen.setText(model.getValueAt(click, 2).toString());
//        tfDonvi.setText(model.getValueAt(click, 3).toString());
//        tfSoluong.setText(model.getValueAt(click, 4).toString());
//
//        String []s1=model.getValueAt(click,5).toString().split("\\s");
//        tfGia.setText(s1[0]);

        //tfGia.setText(model.getValueAt(click, 5).toString());

        this.btnEdit.setEnabled(true);
        this.btnDelete.setEnabled(true);
    }//GEN-LAST:event_tbThucDonMouseClicked

    private void tfFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFindKeyReleased
        ArrayList<ThucDon> arrTable = cn.SearchMon(tfFind.getText());
        if(arrTable != null){
            DefaultTableModel tbmodel = new DefaultTableModel();

            tbmodel.addColumn("Mã Món");
            tbmodel.addColumn("Tên Món");
            tbmodel.addColumn("Mã Loại");
            tbmodel.addColumn("Giá Bán");
            tbmodel.addColumn("ĐVT");
//            tbmodel.addColumn("Số Lượng");

            int somon = 0;
            for (ThucDon td : arrTable) {
                somon++;
                tbmodel.addRow(new Object[]{td.GetMaMon(), td.GetTenMon(), td.GetMaLoai(), td.GetDonGia(), td.GetDVT()});
                soluong.setText(String.valueOf(somon)+" Món");
            }
            tbThucDon.setModel(tbmodel);
            for(int i = 0; i < tbThucDon.getColumnCount();i++){
                Class<?> col = tbThucDon.getColumnClass(i);
                tbThucDon.setDefaultEditor(col, null);
            }
        }
    }//GEN-LAST:event_tfFindKeyReleased

    private void cbbNhomMonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNhomMonItemStateChanged
        Loai selected = (Loai) cbbNhomMon.getSelectedItem();
        loadData(selected.GetMaLoai());
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhomMonItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbbNhomMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel soluong;
    private javax.swing.JScrollPane spDU;
    private javax.swing.JTable tbThucDon;
    private javax.swing.JTextField tfFind;
    // End of variables declaration//GEN-END:variables
}
