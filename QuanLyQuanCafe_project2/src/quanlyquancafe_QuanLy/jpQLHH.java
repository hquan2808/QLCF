/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_QuanLy;
import Models.Detail;
import Sql_and_library.Mysql;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import quanlyquancafe_view.ThemLHH;
/**
 *
 * @author Hoang Quan
 */
public class jpQLHH extends javax.swing.JPanel {
    boolean add = false;
    boolean change = false;
    private Detail detail;
    private String sql="SELECT * FROM tblhanghoa INNER JOIN tblloaihanghoa ON tblhanghoa.MaLHH = tblloaihanghoa.MaLHH ";
    
    /**
     * Creates new form QLHH
     */
    public jpQLHH(Detail d) {
        initComponents();
        setStyle();
        detail= new Detail(d);
        loadData(sql);
        loadLoaiNuoc();
    }
    private void setStyle(){
        lbText.setBackground(new java.awt.Color(0,0,0,0));
        tfDonvi.setBackground(new java.awt.Color(0,0,0,0));
        tfFind.setBackground(new java.awt.Color(0,0,0,0));
        tfGia.setBackground(new java.awt.Color(0,0,0,0));
        tfSoluong.setBackground(new java.awt.Color(0,0,0,0));
        tfTen.setBackground(new java.awt.Color(0,0,0,0));
        tableDrink.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        tableDrink.getTableHeader().setOpaque(false);
        tableDrink.getTableHeader().setBackground(new Color(51,107,135));
        tableDrink.getTableHeader().setForeground(new Color(51,107,135));
        tableDrink.setRowHeight(25);
        
    }
    private void Disabled(){
        lbText.setEnabled(false);
        cbLoai.setEnabled(false);
        tfTen.setEnabled(false);
        tfDonvi.setEnabled(false);
        tfSoluong.setEnabled(false);
        tfGia.setEnabled(false);
    }
    private void Enabled(){
        lbText.setEnabled(true);
        cbLoai.setEnabled(true);
        tfTen.setEnabled(true);
        tfDonvi.setEnabled(true);
        tfSoluong.setEnabled(true);
        tfGia.setEnabled(true);
    }
    private void loadLoaiNuoc(){
        String sql_LHH = "SELECT * FROM tblloaihanghoa ";
        cbLoai.removeAllItems();
        try {
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_LHH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbLoai.addItem(rs.getString("TenLHH"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(jpQLHH.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    private void loadData(String sql){
        try{
            String[] arry={"Mã Đồ Uống","Loại Nước","Tên Nước","Đơn Vị","Số Lượng","Giá Bán"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getString("MaHH").trim());
                vector.add(rs.getString("TenLHH").trim());
                vector.add(rs.getString("TenHH").trim());
                vector.add(rs.getString("donVi").trim());
                vector.add(rs.getInt("SoLuong"));
                vector.add(rs.getString("GiaSP").trim());
                model.addRow(vector);
            }
            tableDrink.setModel(model);
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private double convertedToNumbers(String s){
        String number="";
        String []array=s.replace(","," ").split("\\s");
        for(String i:array){
            number=number.concat(i);
        }
        return Double.parseDouble(number);
    }
    private void reset(){
        add=false;
        change=false;
        loadLoaiNuoc();
        lbText.setText("");
        cbLoai.setSelectedIndex(0);
        tfTen.setText("");
        tfDonvi.setText("");
        tfSoluong.setText("");
        tfGia.setText("");
        lbTrangthai.setText("Trạng Thái");
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnExit.setEnabled(false);
    }
    
    private void checkKyTu(String arry){
        char[] character=arry.toCharArray();
        for(int i = 0; i<character.length;i++){
            if(String.valueOf(character[i]).matches("\\D+")){
                btnSave.setEnabled(false);
                lbTrangthai.setText("Số lượng không thể chứa kí tự");
                break;
            }
            else btnSave.setEnabled(true);
        }
    }
    private boolean checkNull(){
        if(cbLoai.getSelectedItem().equals("")){
            lbTrangthai.setText("Bạn chưa chọn loại thức uống!");
            return false;
        }
        else
        if(tfTen.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập tên thức uống");
            return false;
        }
        else   
        if(tfDonvi.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập đơn vị tính!");
            return false;
        }
        else   
        if(tfSoluong.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập số lượng nước!");
            return false;
        }
        else   
        if(tfGia.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập giá!");
            return false;
        }
        return true;
    }
    private String cutChar(String arry){
        return arry.replaceAll("\\D+","");
    }
    
    private String cutNumber(String arry){
        return arry.replaceAll("\\d+","");
    }
    private void addDrink(){
        if(checkNull()){
            String sqlAdd="INSERT INTO tblhanghoa (MaLHH,TenHH,GiaSP,donVi,SoLuong) VALUES (N'"+cbLoai.getSelectedIndex()+"',N'"+tfTen.getText()+"',N'"+(tfGia.getText().replace(",",""))+"',N'"+tfDonvi.getText()+"',"+tfSoluong.getText()+")";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlAdd);
                ps.execute();
                reset();
                loadData(sql);
                Disabled();
                lbTrangthai.setText("Thêm thức uống thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }   
        }
    }
    private void editDrink(){
         if(checkNull()){
            int click=tableDrink.getSelectedRow();
            TableModel model=tableDrink.getModel();
            String sqlChange="UPDATE tblhanghoa INNER JOIN tblloaihanghoa ON tblhanghoa.MaLHH = tblloaihanghoa.MaLHH SET  tblloaihanghoa.TenLHH=N'"+cbLoai.getSelectedItem()+"', tblhanghoa.TenHH=N'"+tfTen.getText()+"', tblhanghoa.GiaSP='"+(tfGia.getText().replace(",",""))+"', tblhanghoa.donVi='"+tfDonvi.getText()+"',tblhanghoa.SoLuong="+tfSoluong.getText()+" WHERE tblhanghoa.MaHH=N'"+model.getValueAt(click, 0)+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlChange);
                ps.execute();
                reset();
                loadData(sql);
                loadLoaiNuoc();
                Disabled();
                lbTrangthai.setText("Thay đổi thông tin thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
     }
    private boolean check(){
        try {
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("TenHH").toString().trim().equals(tfTen.getText())){
                    lbTrangthai.setText("Thức uống bạn nhập đã tồn tại");
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

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfFind = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        tfDonvi = new javax.swing.JTextField();
        tfSoluong = new javax.swing.JTextField();
        tfGia = new javax.swing.JTextField();
        lbText = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbLoai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        spDU = new javax.swing.JScrollPane();
        tableDrink = new javax.swing.JTable();
        lbTrangthai = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(770, 100));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 107, 135));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quản lý đồ uống");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tfFind.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfFind.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFindActionPerformed(evt);
            }
        });

        btnfind.setBackground(new java.awt.Color(255, 255, 255));
        btnfind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_search_36px_1.png"))); // NOI18N
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(327, 274));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin đồ uống");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Loại đồ uống :");
        jLabel4.setPreferredSize(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tên đồ uống :");
        jLabel5.setPreferredSize(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Đơn vị tính :");
        jLabel6.setPreferredSize(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Số lượng :");
        jLabel7.setPreferredSize(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Giá tiền :");
        jLabel8.setPreferredSize(null);

        tfTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenActionPerformed(evt);
            }
        });

        tfDonvi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfDonvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDonviActionPerformed(evt);
            }
        });

        tfSoluong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoluongActionPerformed(evt);
            }
        });

        tfGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfGiaKeyReleased(evt);
            }
        });

        lbText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbText.setForeground(new java.awt.Color(51, 107, 135));
        lbText.setPreferredSize(new java.awt.Dimension(60, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Mã đồ uống :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSoluong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDonvi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfTen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfGia)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDonvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/floppy-disk.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/plus.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/edit.png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/x-button.png"))); // NOI18N
        btnExit.setEnabled(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete)
                    .addComponent(btnExit))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        spDU.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 107, 135)));

        tableDrink.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDrink.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableDrink.setRowHeight(25);
        tableDrink.setSelectionBackground(new java.awt.Color(51, 107, 135));
        tableDrink.setShowVerticalLines(false);
        tableDrink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDrinkMouseClicked(evt);
            }
        });
        spDU.setViewportView(tableDrink);

        lbTrangthai.setPreferredSize(new java.awt.Dimension(51, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spDU, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfFind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnfind, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(spDU, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFindActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        String sql = "SELECT * FROM tblhanghoa where MaHH like N'%"+tfFind.getText()+"%' or TenLHH like N'%"+tfFind.getText()+"%'";
        loadData(sql);
        tfFind.setText("");
        Disabled();
        reset();
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnfindActionPerformed

    private void tfTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenActionPerformed

    private void tfDonviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDonviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDonviActionPerformed

    private void tfSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoluongActionPerformed
        tfSoluong.setText(cutChar(tfSoluong.getText()));
    }//GEN-LAST:event_tfSoluongActionPerformed

    private void tfGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfGiaKeyReleased
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        if(tfGia.getText().equals("")){
            return;
        }
        else
        if(tfGia.getText().matches("\\D+")){
            tfGia.setText(cutChar(tfGia.getText()));
        }
        else{
            tfGia.setText(formatter.format(convertedToNumbers(cutChar(tfGia.getText()))));
        }
    }//GEN-LAST:event_tfGiaKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(add==true){
            if(check()){
                addDrink();
            }
        }
        else{
            if(change==true)
            editDrink();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        reset();
        add=true;
        Enabled();
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa đồ uống này hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){

            String sqlDelete="DELETE FROM tblhanghoa WHERE MaHH='"+lbText.getText()+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlDelete);
                ps.execute();
                reset();
                loadData(sql);
                Disabled();
                lbTrangthai.setText("Xóa đồ uống thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else reset();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add=false;
        change=true;
        Enabled();
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Disabled();
        reset();
        loadData(sql);
    }//GEN-LAST:event_btnExitActionPerformed

    private void tableDrinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDrinkMouseClicked
        cbLoai.removeAllItems();
        int click=tableDrink.getSelectedRow();
        TableModel model=tableDrink.getModel();

        lbText.setText(model.getValueAt(click, 0).toString());
        cbLoai.addItem(model.getValueAt(click, 1).toString());
        tfTen.setText(model.getValueAt(click, 2).toString());
        tfDonvi.setText(model.getValueAt(click, 3).toString());
        tfSoluong.setText(model.getValueAt(click, 4).toString());

        String []s1=model.getValueAt(click,5).toString().split("\\s");
        tfGia.setText(s1[0]);

        //tfGia.setText(model.getValueAt(click, 5).toString());

        this.btnEdit.setEnabled(true);
        this.btnDelete.setEnabled(true);
    }//GEN-LAST:event_tableDrinkMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnfind;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JScrollPane spDU;
    private javax.swing.JTable tableDrink;
    private javax.swing.JTextField tfDonvi;
    private javax.swing.JTextField tfFind;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfSoluong;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables
}
