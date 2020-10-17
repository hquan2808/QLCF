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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Dell
 */
public class QLNV extends javax.swing.JFrame {
    /**
     * Creates new form QLNV
     */
    boolean add = false;
    boolean change = false;
    private Detail detail;
    private String sql="SELECT * FROM qlnv ORDER BY maNV";
    public QLNV(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        detail = new Detail(d); 
        Disabled();
        loadData(sql);
        checkGT(sql);
        
    }
    private String gioiTinh() {
        if (radionam.isSelected()) {
            return radionam.getText();
        }else{
            return radionu.getText();
        }
    }
    private void reset(){
        add=false;
        change=false;
        texthoten.setText("");
        textsdt.setText("");
        textdiachi.setText("");
        textmanv.setText("");
        textmatkhau.setText("");
        textxacnhanmk.setText("");
        textngaysinh.setText("");
        texttaikhoan.setText("");
        textsdt.setText("");
        lbtrangthai.setText("Trạng Thái");
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnExit.setEnabled(false);
    }
    private void Disabled(){
        texthoten.setEnabled(false);
        textdiachi.setEnabled(false);
        textmanv.setEnabled(false);
        textmatkhau.setEnabled(false);
        textngaysinh.setEnabled(false);
        textsdt.setEnabled(false);
        texttaikhoan.setEnabled(false);
        textxacnhanmk.setEnabled(false);
        radionu.setEnabled(false);
        radionam.setEnabled(false);   
    }
    private void Enabled(){
        texthoten.setEnabled(true);
        textdiachi.setEnabled(true);
        textmanv.setEnabled(true);
        textmatkhau.setEnabled(true);
        textngaysinh.setEnabled(true);
        textsdt.setEnabled(true);
        texttaikhoan.setEnabled(true);
        textxacnhanmk.setEnabled(true);
        radionu.setEnabled(true);
        radionam.setEnabled(true);   
    }
    private boolean checkNull(){
        if(textmatkhau.getText().equals("")){
            lbtrangthai.setText("Bạn chưa nhập SĐT!");
            return false;
        }
        else   
        if(texttaikhoan.getText().equals("")){
            lbtrangthai.setText("Bạn chưa nhập địa chỉ!");
            return false;
        }
        
        return true;
    }
        private void checkGT(String GT){
        if (GT.equals("Nam")) {
            radionam.setSelected(true);
        }else{
            radionu.setSelected(true);
        }
    }
    private void addNV() throws SQLException{
        if(checkNull()){
            String sqlAddNV = "INSERT INTO QLNV (maNV,tenNV,ngaySinh,sdt,gioiTinh,diaChi,taiKhoan,matKhau,Roll) VALUES (N'"+textmanv.getText()+"',N'"+texthoten.getText()+"',N'"+textngaysinh.getText()+"',N'"+textsdt.getText()+"',N'"+gioiTinh()+"',N'"+textdiachi.getText()+"',N'"+texttaikhoan.getText()+"',N'"+textmatkhau.getText()+"',1)";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlAddNV);
                System.out.println(ps);
                ps.execute();
                loadData(sql);
                Disabled();
                check();
                lbtrangthai.setText("Thêm nhân viên thành công!");
            } catch (SQLException ea) {
                ea.printStackTrace();
            }
        }
    }
    private void editNV(){
        if(checkNull()){
            int click=table_QLNV.getSelectedRow();
            TableModel model=table_QLNV.getModel();
        
            String sqlChange="UPDATE QLNV SET maNV='"+textmanv.getText()+"', tenNV=N'"+texthoten.getText()+"', ngaySinh=N'"+textngaysinh.getText()+"', sdt='"+(textsdt.getText())+"', diaChi='"+textdiachi.getText()+"' WHERE maNV=N'"+model.getValueAt(click, 0)+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlChange);
                ps.execute();
                reset();
                loadData(sql);
                
                lbtrangthai.setText("Thay đổi thông tin thành công!");
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
                if(rs.getString("maNV").toString().trim().equals(textmanv.getText())){
                    lbtrangthai.setText("Mã nhân viên đã tồn tại");
                    return false;
                }
                else
                if(rs.getString("taiKhoan").toString().trim().equals(texttaikhoan.getText())){
                    lbtrangthai.setText("Tài khoản đã tồn tại");
                    return false;
                }else
                    if(!textxacnhanmk.getText().equals(textmatkhau.getText())){
                        lbtrangthai.setText("Mật khẩu không giống nhau!");
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
    private void loadData(String sql){
        try{
            String[] arry={"Mã nhân viên","Họ và Tên","Giới tính","Ngày sinh","SĐT","Địa chỉ"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getString("maNV").trim());
                vector.add(rs.getString("tenNV").trim());
                vector.add(rs.getString("gioiTinh").trim());
                vector.add(rs.getString("ngaySinh").trim());
                vector.add(rs.getString("sdt").trim());
                vector.add(rs.getString("diaChi").trim());
                model.addRow(vector);
            }
            table_QLNV.setModel(model);
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_QLNV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        textsdt = new javax.swing.JTextField();
        texttaikhoan = new javax.swing.JTextField();
        textdiachi = new javax.swing.JTextField();
        texthoten = new javax.swing.JTextField();
        lbgioitinh = new javax.swing.JLabel();
        lbhoten = new javax.swing.JLabel();
        lbngaysinh = new javax.swing.JLabel();
        radionu = new javax.swing.JRadioButton();
        lbmatkhau = new javax.swing.JLabel();
        lbmanv = new javax.swing.JLabel();
        radionam = new javax.swing.JRadioButton();
        textmanv = new javax.swing.JTextField();
        lbdiachi = new javax.swing.JLabel();
        lbtaikhoan = new javax.swing.JLabel();
        lbsdt = new javax.swing.JLabel();
        textngaysinh = new javax.swing.JTextField();
        lbxacnhanmk = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textmatkhau = new javax.swing.JPasswordField();
        textxacnhanmk = new javax.swing.JPasswordField();
        jTextField10 = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        lbtrangthai = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1178, 507));

        jPanel1.setPreferredSize(new java.awt.Dimension(1092, 632));

        table_QLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Giới tính", "Ngày sinh", "SĐT", "Địa chỉ"
            }
        ));
        table_QLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_QLNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_QLNV);
        if (table_QLNV.getColumnModel().getColumnCount() > 0) {
            table_QLNV.getColumnModel().getColumn(0).setHeaderValue("Mã nhân viên");
            table_QLNV.getColumnModel().getColumn(1).setHeaderValue("Họ tên");
            table_QLNV.getColumnModel().getColumn(2).setHeaderValue("Giới tính");
            table_QLNV.getColumnModel().getColumn(3).setHeaderValue("Ngày sinh");
            table_QLNV.getColumnModel().getColumn(4).setHeaderValue("SĐT");
            table_QLNV.getColumnModel().getColumn(5).setHeaderValue("Địa chỉ");
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Thông tin");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_search_black_24dp.png"))); // NOI18N

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/user (1).png"))); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 70));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/user.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 70));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/user(2).png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(100, 70));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/floppy-disk (1).png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setPreferredSize(new java.awt.Dimension(100, 70));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        textsdt.setMinimumSize(new java.awt.Dimension(6, 30));

        texttaikhoan.setMinimumSize(new java.awt.Dimension(6, 30));
        texttaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texttaikhoanActionPerformed(evt);
            }
        });

        textdiachi.setMinimumSize(new java.awt.Dimension(6, 30));

        texthoten.setMinimumSize(new java.awt.Dimension(6, 30));

        lbgioitinh.setText("Giới tính :");

        lbhoten.setText("Họ và tên:");

        lbngaysinh.setText("Ngày sinh:");

        buttonGroup1.add(radionu);
        radionu.setText("Nữ");
        radionu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radionuActionPerformed(evt);
            }
        });

        lbmatkhau.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmatkhau.setText("Mật khẩu :");

        lbmanv.setText("Mã nhân viên:");

        buttonGroup1.add(radionam);
        radionam.setText("Nam");

        textmanv.setMinimumSize(new java.awt.Dimension(6, 30));

        lbdiachi.setText("Địa chỉ:");

        lbtaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtaikhoan.setText("Tài khoản :");

        lbsdt.setText("SĐT:");

        textngaysinh.setMinimumSize(new java.awt.Dimension(6, 30));

        lbxacnhanmk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbxacnhanmk.setText("Xác nhận mk:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbdiachi)
                    .addComponent(lbmanv)
                    .addComponent(lbhoten)
                    .addComponent(lbngaysinh)
                    .addComponent(lbsdt))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textdiachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(texthoten, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(textmanv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textsdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbgioitinh)
                            .addComponent(lbtaikhoan)
                            .addComponent(lbmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbxacnhanmk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(radionu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(radionam))
                                    .addComponent(texttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(textxacnhanmk))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbgioitinh)
                            .addComponent(radionu)
                            .addComponent(radionam))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmanv))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhoten))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbngaysinh)
                        .addComponent(textngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbtaikhoan)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbsdt)
                    .addComponent(textsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmatkhau)
                    .addComponent(textmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbdiachi)
                        .addComponent(textdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbxacnhanmk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textxacnhanmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/x-button.png"))); // NOI18N
        btnExit.setEnabled(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbtrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbtrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnExit, btnSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý nhân viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        quanlyquancafe_Main main = new quanlyquancafe_Main(detail);
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radionuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radionuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radionuActionPerformed

    private void texttaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texttaikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texttaikhoanActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        reset();
        add = true;
        Enabled();
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnExit.setEnabled(true);
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(add==true){
            if(check()){
                try {
                    addNV();
                } catch (SQLException ex) {
                    Logger.getLogger(QLNV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
            if(change==true){
                editNV();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void table_QLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QLNVMouseClicked
        // TODO add your handling code here:
//        cbLoai.removeAllItems();
        int click=table_QLNV.getSelectedRow();
        TableModel model=table_QLNV.getModel();
        
        textmanv.setText(model.getValueAt(click, 0).toString());
        texthoten.setText(model.getValueAt(click, 1).toString());
        textngaysinh.setText(model.getValueAt(click, 3).toString());
        textsdt.setText(model.getValueAt(click, 4).toString());
        textdiachi.setText(model.getValueAt(click, 5).toString());
        checkGT(model.getValueAt(click, 2).toString());
        
        loadAccount(model.getValueAt(click, 0).toString());
        this.btnEdit.setEnabled(true);
        this.btnDelete.setEnabled(true);
    }//GEN-LAST:event_table_QLNVMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Disabled(); 
        reset();
        loadData(sql);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên này hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
            
            String sqlDelete="DELETE FROM QLNV WHERE maNV='"+textmanv.getText()+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlDelete);
                ps.execute();
                reset();
                loadData(sql);
                Disabled();
                lbtrangthai.setText("Xóa nhân viên thành công!");
                this.btnDelete.setEnabled(false);
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
        else reset();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        add=false;
        change=true;
        Enabled();
        texttaikhoan.setEnabled(false);
        textxacnhanmk.setEnabled(false);
        textmatkhau.setEnabled(false);
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
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detail detail= new Detail();
//                if(detail.getRoll().equals("3")){
//                   new QLNV(detail).setVisible(false);
//                   Login login = new Login();
//                   login.setVisible(true);
//                }else{
                new QLNV(detail).setVisible(true);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JLabel lbdiachi;
    private javax.swing.JLabel lbgioitinh;
    private javax.swing.JLabel lbhoten;
    private javax.swing.JLabel lbmanv;
    private javax.swing.JLabel lbmatkhau;
    private javax.swing.JLabel lbngaysinh;
    private javax.swing.JLabel lbsdt;
    private javax.swing.JLabel lbtaikhoan;
    private javax.swing.JLabel lbtrangthai;
    private javax.swing.JLabel lbxacnhanmk;
    private javax.swing.JRadioButton radionam;
    private javax.swing.JRadioButton radionu;
    private javax.swing.JTable table_QLNV;
    private javax.swing.JTextField textdiachi;
    private javax.swing.JTextField texthoten;
    private javax.swing.JTextField textmanv;
    private javax.swing.JPasswordField textmatkhau;
    private javax.swing.JTextField textngaysinh;
    private javax.swing.JTextField textsdt;
    private javax.swing.JTextField texttaikhoan;
    private javax.swing.JPasswordField textxacnhanmk;
    // End of variables declaration//GEN-END:variables

    private void loadAccount(String s) {
        try {
            String sql = "SELECT * FROM QLNV WHERE maNV = '"+s+"'";
            
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                texttaikhoan.setText(rs.getString("taiKhoan").trim());
                textmatkhau.setText(rs.getString("matKhau").trim());
                textxacnhanmk.setText(rs.getString("matKhau").trim());
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    


}
