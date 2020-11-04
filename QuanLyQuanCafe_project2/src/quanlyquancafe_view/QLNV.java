/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Models.Detail;
import Sql_and_library.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
        setStyle();
        detail = new Detail(d); 
        Disabled();
        loadData(sql);
        loadChucvu();
    }
    private void setStyle(){
        tfMa.setBackground(new java.awt.Color(0,0,0,0));
        tfDiachi.setBackground(new java.awt.Color(0,0,0,0));
        tfMatkhau.setBackground(new java.awt.Color(0,0,0,0));
        tfNgaysinh.setBackground(new java.awt.Color(0,0,0,0));
        tfSdt.setBackground(new java.awt.Color(0,0,0,0));
        tfTaikhoan.setBackground(new java.awt.Color(0,0,0,0));
        tfTen.setBackground(new java.awt.Color(0,0,0,0));
        tfXacnhanmk.setBackground(new java.awt.Color(0,0,0,0));
        table_QLNV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
        table_QLNV.getTableHeader().setOpaque(false);
        table_QLNV.getTableHeader().setBackground(new Color(51,107,135));
        table_QLNV.getTableHeader().setForeground(new Color(51,107,135));
        table_QLNV.setRowHeight(25);
        
    }
    private String gioiTinh() {
        if (rbNam.isSelected()) {
            return rbNam.getText();
        }else{
            return rbNu.getText();
        }
    }
    private void reset(){
        add=false;
        change=false;
        tfTen.setText("");
        tfSdt.setText("");
        tfDiachi.setText("");
        tfMa.setText("");
        loadChucvu();
        tfMatkhau.setText("");
        tfXacnhanmk.setText("");
        ((JTextField)tfNgaysinh.getDateEditor().getUiComponent()).setText("");
        tfTaikhoan.setText("");
        tfSdt.setText("");
        lbTrangthai.setText("Trạng Thái");
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnExit.setEnabled(false);
    }
    private void loadChucvu(){
        cbChucvu.removeAllItems();
        cbChucvu.addItem("Quản lí");
        cbChucvu.addItem("Nhân viên");
    }
    private void Disabled(){
        tfTen.setEnabled(false);
        tfDiachi.setEnabled(false);
        tfMa.setEnabled(false);
        tfMatkhau.setEnabled(false);
        cbChucvu.setEnabled(false);
        tfNgaysinh.setEnabled(false);
        tfSdt.setEnabled(false);
        tfTaikhoan.setEnabled(false);
        tfXacnhanmk.setEnabled(false);
        rbNu.setEnabled(false);
        rbNam.setEnabled(false);   
    }
    private void Enabled(){
        tfTen.setEnabled(true);
        tfDiachi.setEnabled(true);
        tfMa.setEnabled(true);
        tfMatkhau.setEnabled(true);
        tfNgaysinh.setEnabled(true);
        cbChucvu.setEnabled(true);
        tfSdt.setEnabled(true);
        tfTaikhoan.setEnabled(true);
        tfXacnhanmk.setEnabled(true);
        rbNu.setEnabled(true);
        rbNam.setEnabled(true);   
    }
    private boolean checkNull(){
        if(tfMa.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập mã nhân viên!");
            return false;
        }
        else
        if(tfTen.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập họ tên nhân viên!");
            return false;
        }
        else
        if(rbNam.isSelected()==false && rbNu.isSelected()==false){
            lbTrangthai.setText("Bạn chưa chọn giới tính!");
            return false;
        }
        else
        if(((JTextField)tfNgaysinh.getDateEditor().getUiComponent()).getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập ngày sinh!");
            return false;
        }
        else   
        if(tfSdt.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập số điện thoại!");
            return false;
        }
        else   
        if(tfDiachi.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập địa chỉ!");
            return false;
        }
        else
        if(tfTaikhoan.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập tài khoản!");
            return false;
        }
        else
        if(tfMatkhau.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập mật khẩu!");
            return false;
        }
        else
        if(tfXacnhanmk.getText().equals("")){
            lbTrangthai.setText("Bạn chưa nhập lại mật khẩu!");
            return false;
        }
        else
        if(String.valueOf(tfMatkhau.getPassword()).equals(String.valueOf(tfXacnhanmk.getPassword()))){
            return true;
        }
        else {
            lbTrangthai.setText("Nhập lại mật khẩu không đúng!");
            return false;
        }
    }
        private void checkGT(String GT){
        if (GT.equals("Nam")) {
            rbNam.setSelected(true);
        }else{
            rbNu.setSelected(true);
        }
    }
    private void addNV(){
        if(checkNull()){
            try {
                String sqlAddNV = "INSERT INTO QLNV (maNV,tenNV,ngaySinh,sdt,gioiTinh,diaChi,taiKhoan,matKhau,Roll) VALUES (N'"+tfMa.getText()+"',N'"+tfTen.getText()+"',N'"+((JTextField)tfNgaysinh.getDateEditor().getUiComponent()).getText()+"',N'"+tfSdt.getText()+"',N'"+gioiTinh()+"',N'"+tfDiachi.getText()+"',N'"+tfTaikhoan.getText()+"',N'"+tfMatkhau.getText()+"',N'"+cbChucvu.getSelectedItem().toString()+"')";
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlAddNV);
                ps.execute();
                loadData(sql);
                Disabled();
                table_QLNV.setVisible(true);
                lbTrangthai.setText("Thêm nhân viên thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void editNV(){
        if(checkNull()){
            int click=table_QLNV.getSelectedRow();
            TableModel model=table_QLNV.getModel();
            String sqlChange="UPDATE QLNV SET maNV='"+tfMa.getText()+"',Roll='"+cbChucvu.getSelectedItem().toString()+"', tenNV=N'"+tfTen.getText()+"', ngaySinh='"+((JTextField)tfNgaysinh.getDateEditor().getUiComponent()).getText()+"',gioiTinh='"+gioiTinh()+"', sdt='"+(tfSdt.getText())+"', diaChi='"+tfDiachi.getText()+"',taiKhoan='"+(tfTaikhoan.getText())+"',matKhau='"+(tfMatkhau.getText())+"' WHERE maNV=N'"+model.getValueAt(click, 0)+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlChange);
                ps.execute();
                reset();
                loadData(sql);
                Disabled();
                table_QLNV.setVisible(true);
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
                if(rs.getString("maNV").toString().trim().equals(tfMa.getText())){
                    lbTrangthai.setText("Mã nhân viên đã tồn tại");
                    return false;
                }
                else if(rs.getString("taiKhoan").toString().trim().equals(tfTaikhoan.getText())){
                    lbTrangthai.setText("Tài khoản đã tồn tại");
                    return false;
                }else if(String.valueOf(tfMatkhau.getPassword()).equals(String.valueOf(tfXacnhanmk.getPassword()))){
                    return true;
                }
                else {
                    lbTrangthai.setText("Nhập lại mật khẩu không đúng!");
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
            String[] arry={"Mã nhân viên","Họ và Tên","Giới tính","Ngày sinh","SĐT","Địa chỉ","Chức vụ"};
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
                vector.add(rs.getString("Roll").trim());
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
        spTable = new javax.swing.JScrollPane();
        table_QLNV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tfSdt = new javax.swing.JTextField();
        tfTaikhoan = new javax.swing.JTextField();
        tfDiachi = new javax.swing.JTextField();
        tfTen = new javax.swing.JTextField();
        lbgioitinh = new javax.swing.JLabel();
        lbhoten = new javax.swing.JLabel();
        lbngaysinh = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
        lbmatkhau = new javax.swing.JLabel();
        lbmanv = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        tfMa = new javax.swing.JTextField();
        lbdiachi = new javax.swing.JLabel();
        lbtaikhoan = new javax.swing.JLabel();
        lbsdt = new javax.swing.JLabel();
        lbxacnhanmk = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfMatkhau = new javax.swing.JPasswordField();
        tfXacnhanmk = new javax.swing.JPasswordField();
        tfNgaysinh = new com.toedter.calendar.JDateChooser();
        cbChucvu = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfFind = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1178, 507));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1092, 632));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 107, 135)));
        spTable.setForeground(new java.awt.Color(51, 107, 135));

        table_QLNV.setForeground(new java.awt.Color(51, 107, 135));
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
        table_QLNV.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_QLNV.setRowHeight(25);
        table_QLNV.setSelectionBackground(new java.awt.Color(51, 107, 135));
        table_QLNV.setShowVerticalLines(false);
        table_QLNV.getTableHeader().setReorderingAllowed(false);
        table_QLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_QLNVMouseClicked(evt);
            }
        });
        spTable.setViewportView(table_QLNV);
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

        btnFind.setBackground(new java.awt.Color(255, 255, 255));
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_search_36px_1.png"))); // NOI18N
        btnFind.setOpaque(false);
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/user (1).png"))); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 70));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/user.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(100, 70));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/user(2).png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(100, 70));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/floppy-disk (1).png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setPreferredSize(new java.awt.Dimension(100, 70));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tfSdt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfSdt.setMinimumSize(new java.awt.Dimension(6, 30));
        tfSdt.setOpaque(false);
        tfSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSdtKeyReleased(evt);
            }
        });

        tfTaikhoan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfTaikhoan.setMinimumSize(new java.awt.Dimension(6, 30));
        tfTaikhoan.setOpaque(false);
        tfTaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTaikhoanActionPerformed(evt);
            }
        });

        tfDiachi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfDiachi.setMinimumSize(new java.awt.Dimension(6, 30));

        tfTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfTen.setMinimumSize(new java.awt.Dimension(6, 30));
        tfTen.setOpaque(false);

        lbgioitinh.setText("Giới tính :");

        lbhoten.setText("Họ và tên:");

        lbngaysinh.setText("Ngày sinh:");

        rbNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbNu);
        rbNu.setText("Nữ");
        rbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuActionPerformed(evt);
            }
        });

        lbmatkhau.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbmatkhau.setText("Mật khẩu :");

        lbmanv.setText("Mã nhân viên:");

        rbNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbNam);
        rbNam.setText("Nam");

        tfMa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfMa.setMinimumSize(new java.awt.Dimension(6, 30));

        lbdiachi.setText("Địa chỉ:");

        lbtaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbtaikhoan.setText("Tài khoản :");

        lbsdt.setText("SĐT:");

        lbxacnhanmk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbxacnhanmk.setText("Xác nhận mk:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tfMatkhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfMatkhau.setOpaque(false);

        tfXacnhanmk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfXacnhanmk.setOpaque(false);

        tfNgaysinh.setBackground(new java.awt.Color(255, 255, 255));
        tfNgaysinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 107, 135)));
        tfNgaysinh.setOpaque(false);

        cbChucvu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Chức vụ:");

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfDiachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbgioitinh)
                            .addComponent(lbtaikhoan)
                            .addComponent(lbmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbxacnhanmk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfMatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(tfXacnhanmk)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbChucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(rbNu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbNam))
                                    .addComponent(tfTaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmanv))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhoten))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbgioitinh)
                            .addComponent(rbNu)
                            .addComponent(rbNam))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbngaysinh)
                        .addComponent(lbtaikhoan))
                    .addComponent(tfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbsdt)
                    .addComponent(tfSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmatkhau)
                    .addComponent(tfMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbdiachi)
                        .addComponent(tfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbxacnhanmk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfXacnhanmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfFind.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 107, 135)));
        tfFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFindActionPerformed(evt);
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

        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 755, Short.MAX_VALUE)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(170, 170, 170)
                                    .addComponent(jLabel1))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnExit, btnSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addComponent(tfFind, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 107, 135));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản lý nhân viên");

        jPanel3.setBackground(new java.awt.Color(51, 107, 135));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_back_arrow_50px.png"))); // NOI18N
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_home)
                .addGap(112, 112, 112)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(349, 349, 349))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_home)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNuActionPerformed

    private void tfTaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTaikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTaikhoanActionPerformed

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
        if(add==true){
            if(check()){
                addNV();
            }
        }
        else{
            if(change==true)
                editNV();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void table_QLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QLNVMouseClicked
        cbChucvu.removeAllItems();
        int click=table_QLNV.getSelectedRow();
        TableModel model=table_QLNV.getModel();
        
        tfMa.setText(model.getValueAt(click, 0).toString());
        tfTen.setText(model.getValueAt(click, 1).toString());
        ((JTextField)tfNgaysinh.getDateEditor().getUiComponent()).setText(model.getValueAt(click, 3).toString());
        tfSdt.setText(model.getValueAt(click, 4).toString());
        tfDiachi.setText(model.getValueAt(click, 5).toString());
        cbChucvu.addItem(model.getValueAt(click, 6).toString());
        checkGT(model.getValueAt(click, 2).toString());
        
        loadAccount(model.getValueAt(click, 0).toString());
        this.btnEdit.setEnabled(true);
        this.btnDelete.setEnabled(true);
    }//GEN-LAST:event_table_QLNVMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        Disabled();
        table_QLNV.setVisible(true);
        reset();
        loadData(sql);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên này hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
            
            String sqlDelete="DELETE FROM QLNV WHERE maNV='"+tfMa.getText()+"'";
            try {
                Connection conn = Mysql.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlDelete);
                ps.execute();
                reset();
                loadData(sql);
                Disabled();
                lbTrangthai.setText("Xóa nhân viên thành công!");
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
        loadChucvu();
        table_QLNV.setVisible(false);
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed
    private String cutChar(String arry){
        return arry.replaceAll("\\D+","");
    }
    private void tfSdtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSdtKeyReleased
       tfSdt.setText(cutChar(tfSdt.getText()));
        
        if(tfSdt.getText().length()==11 || tfSdt.getText().length()==10 ){
            
            btnSave.setEnabled(true);
            lbTrangthai.setText("Số điện thoại đã hợp lệ!!");
        }
        else
        if(tfSdt.getText().length()>11 || tfSdt.getText().length()<10){
            btnSave.setEnabled(false);
            lbTrangthai.setText("Số điện thoại không được nhỏ hơn 10 số hoặc vượt quá 11 số!!");
        }
    }//GEN-LAST:event_tfSdtKeyReleased
    private void checkDecentralization(){
        if(String.valueOf(detail.getUser().substring(0, 4)).equals("User")){
            btnAdd.setEnabled(false);
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
            btnSave.setEnabled(false);
            btnExit.setEnabled(false);
        }
    }
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String sql = "SELECT * FROM QLNV where maNV like N'%"+tfFind.getText()+"%' or tenNV like N'%"+tfFind.getText()+"%' or gioiTinh like N'%"+tfFind.getText()+"%' or ngaySinh like N'%"+tfFind.getText()+"%' or sdt like N'%"+tfFind.getText()+"%' or diaChi like N'%"+tfFind.getText()+"%' or taiKhoan like N'%"+tfFind.getText()+"%' or Roll like N'%"+tfFind.getText()+"'";
        Disabled();
        loadData(sql);
        tfFind.setText("");
        reset();
        checkDecentralization();
        btnExit.setEnabled(true);
    }//GEN-LAST:event_btnFindActionPerformed

    private void tfFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFindActionPerformed

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        // TODO add your handling code here:
        quanlyquancafe_Main home = new quanlyquancafe_Main(detail);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btn_homeMousePressed

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
                }
//            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel btn_home;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbChucvu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JLabel lbdiachi;
    private javax.swing.JLabel lbgioitinh;
    private javax.swing.JLabel lbhoten;
    private javax.swing.JLabel lbmanv;
    private javax.swing.JLabel lbmatkhau;
    private javax.swing.JLabel lbngaysinh;
    private javax.swing.JLabel lbsdt;
    private javax.swing.JLabel lbtaikhoan;
    private javax.swing.JLabel lbxacnhanmk;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JTable table_QLNV;
    private javax.swing.JTextField tfDiachi;
    private javax.swing.JTextField tfFind;
    private javax.swing.JTextField tfMa;
    private javax.swing.JPasswordField tfMatkhau;
    private com.toedter.calendar.JDateChooser tfNgaysinh;
    private javax.swing.JTextField tfSdt;
    private javax.swing.JTextField tfTaikhoan;
    private javax.swing.JTextField tfTen;
    private javax.swing.JPasswordField tfXacnhanmk;
    // End of variables declaration//GEN-END:variables

    private void loadAccount(String s) {
        try {
            String sql = "SELECT * FROM QLNV WHERE maNV = '"+s+"'";
            
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tfTaikhoan.setText(rs.getString("taiKhoan").trim());
                tfMatkhau.setText(rs.getString("matKhau").trim());
                tfXacnhanmk.setText(rs.getString("matKhau").trim());
            } 
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
