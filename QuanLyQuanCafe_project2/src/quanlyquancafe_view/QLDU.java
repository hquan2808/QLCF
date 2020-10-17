/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Sql.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dell
 */
public class QLDU extends javax.swing.JFrame {

    boolean add = false;
    boolean change = false;
    private Detail detail;
    private String sql="SELECT * FROM QLDU ORDER BY maNuoc";
    /**
     * Creates new form QLDU
     */
    public QLDU(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        detail= new Detail(d);
        loadData(sql);
        loadLoaiNuoc();
        Disabled();
    }
    private void Disabled(){
        tfMa.setEnabled(false);
        cbLoai.setEnabled(false);
        tfTen.setEnabled(false);
        tfDonvi.setEnabled(false);
        tfSoluong.setEnabled(false);
        tfGia.setEnabled(false);
        
    }
    private void Enabled(){
        tfMa.setEnabled(true);
        cbLoai.setEnabled(true);
        tfTen.setEnabled(true);
        tfDonvi.setEnabled(true);
        tfSoluong.setEnabled(true);
        tfGia.setEnabled(true);
    }
    private void loadLoaiNuoc(){
        cbLoai.removeAllItems();
        cbLoai.addItem("Cafe");
        cbLoai.addItem("Sinh Tố");
        cbLoai.addItem("Nước Giải Khát");
        cbLoai.addItem("Bánh ngọt");
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
                vector.add(rs.getString("maNuoc").trim());
                vector.add(rs.getString("loaiNuoc").trim());
                vector.add(rs.getString("tenNuoc").trim());
                vector.add(rs.getString("donVi").trim());
                vector.add(rs.getInt("soLuong"));
                vector.add(rs.getString("giaBan").trim());
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
        tfMa.setText("");
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
        if(tfMa.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập mã đồ uống!");
            return false;
        }
        else
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
            String sqlAdd="INSERT INTO QLDU (maNuoc,loaiNuoc,tenNuoc,giaBan,donVi,soLuong) VALUES (N'"+tfMa.getText()+"',N'"+cbLoai.getSelectedItem().toString()+"',N'"+tfTen.getText()+"',N'"+(tfGia.getText()+" "+"VNĐ")+"',N'"+tfDonvi.getText()+"',"+tfSoluong.getText()+")";
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
        
            String sqlChange="UPDATE QLDU SET maNuoc='"+tfMa.getText()+"', loaiNuoc=N'"+cbLoai.getSelectedItem()+"', tenNuoc=N'"+tfTen.getText()+"', giaBan='"+(tfGia.getText()+" "+"VNĐ")+"', donVi='"+tfDonvi.getText()+"',soLuong="+tfSoluong.getText()+" WHERE maNuoc=N'"+model.getValueAt(click, 0)+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlChange);
                ps.execute();
                reset();
                loadData(sql);
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
                if(rs.getString("maNuoc").toString().trim().equals(tfMa.getText())){
                    lbTrangthai.setText("Mã nước bạn nhập đã tồn tại");
                    return false;
                }
                else
                if(rs.getString("tenNuoc").toString().trim().equals(tfTen.getText())){
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

        Home_QLDU = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDrink = new javax.swing.JTable();
        tfFind = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfMa = new javax.swing.JTextField();
        tfTen = new javax.swing.JTextField();
        tfDonvi = new javax.swing.JTextField();
        tfSoluong = new javax.swing.JTextField();
        tfGia = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý đồ uống");

        Home_QLDU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/home.png"))); // NOI18N
        Home_QLDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_QLDUActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý đồ uống");

        tableDrink.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableDrink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã đồ uống", "Tên đồ uống", "Sô lượng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableDrink.setPreferredSize(new java.awt.Dimension(150, 64));
        tableDrink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDrinkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDrink);

        btnfind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/search.png"))); // NOI18N
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(327, 274));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin đồ uống");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã đồ uống :");
        jLabel3.setPreferredSize(null);

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

        tfMa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenActionPerformed(evt);
            }
        });

        tfDonvi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfDonvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDonviActionPerformed(evt);
            }
        });

        tfSoluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfGiaKeyReleased(evt);
            }
        });

        cbLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMa)
                            .addComponent(tfSoluong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDonvi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfTen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfGia))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
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

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/floppy-disk.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/plus.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/delete.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/edit.png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

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
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbTrangthai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setText("Trạng thái");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Home_QLDU, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Home_QLDU, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFind))
                        .addGap(10, 10, 10)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDonviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDonviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDonviActionPerformed

    private void tfTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Disabled();
        reset();
        loadData(sql);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
       String sql = "SELECT * FROM QLDU where maNuoc like N'%"+tfFind.getText()+"%' or tenNuoc like N'%"+tfFind.getText()+"%' or loaiNuoc like N'%"+tfFind.getText()+"%'";
        loadData(sql);
        tfFind.setText("");
        Disabled();
        reset();
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnfindActionPerformed

    private void tableDrinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDrinkMouseClicked
        cbLoai.removeAllItems();
        int click=tableDrink.getSelectedRow();
        TableModel model=tableDrink.getModel();
        
        tfMa.setText(model.getValueAt(click, 0).toString());
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa đồ uống này hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
            
            String sqlDelete="DELETE FROM QLDU WHERE maNuoc='"+tfMa.getText()+"'";
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
    private void Home_QLDUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_QLDUActionPerformed
        // TODO add your handling code here:
        quanlyquancafe_Main  main = new quanlyquancafe_Main(detail);
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_Home_QLDUActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        reset();
        add=true;
        Enabled();
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(QLDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              Detail detail= new Detail();
//                if(detail.getRoll().equals("3")){
//                   new QLDU(detail).setVisible(false);
//                   Login login = new Login();
//                   login.setVisible(true);
//                }else{
                new QLDU(detail).setVisible(true);
//                }
                }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home_QLDU;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnfind;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JTable tableDrink;
    private javax.swing.JTextField tfDonvi;
    private javax.swing.JTextField tfFind;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfMa;
    private javax.swing.JTextField tfSoluong;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables
}
