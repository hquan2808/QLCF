/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycafe_Banhang;

import Models.Detail;
import Models.Ban;
import Sql_and_library.Mysql;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import quanlyquancafe_view.quanlyquancafe_Main;

/**
 *
 * @author Dell
 */
public class BanHang extends javax.swing.JFrame implements Runnable,ActionListener {
    private Detail detail;
    private Thread thread;
    private Mysql con1 = new Mysql();
    ArrayList<Ban> arrBan;
    ArrayList<Ban> ban;
    int MaBan;
    
    public static BanHang bh;
    public BanHang(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        detail = new Detail(d);
        lbNhanVien.setText(d.getName());
        lblTime.setText(String.valueOf(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date())));
        lblDate.setText(String.valueOf(new SimpleDateFormat("EEEE dd/MM/yyyy").format(new java.util.Date())));
        Start();
        taoBan();
        fillLb();
        bh = this;
    }
    public void fillLb(){
        jPanel2.removeAll();
        jPanel2.add(jLabel2);
        jPanel2.updateUI();        
    }
    public void taoBan(){
        arrBan = con1.GetBan(0);
        if(arrBan != null){
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for(int i=0;i<arrBan.size();i++){
                btn[i] = new JButton();
                btn[i].setName(String.valueOf(arrBan.get(i).GetMaBan()));
                String[] mb = arrBan.get(i).GetTenBan().split(" ");
                btn[i].setText(mb[1]);
                btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/bantrong.png")));
                Border thickBorder = new LineBorder(Color.WHITE,8);
                btn[i].setBorder(thickBorder);
                btn[i].setBackground(Color.decode("#8080ff"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
                if(arrBan.get(i).GetTrangThai().equals("Đang phục vụ")){
                    btn[i].setBackground(Color.decode("#66ff66"));
                }
                if(arrBan.get(i).GetTrangThai().equals("Đã đặt trước")){
                    btn[i].setBackground(Color.decode("#ff6699"));
                }                
                btn[i].setPreferredSize(new Dimension(90, 70));

                btn[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            JpGoiMon goimon;
                            ban = con1.GetBan(Integer.parseInt(e.getComponent().getName()));
                            if(ban != null){                            
                                goimon = new JpGoiMon(ban.get(0).GetTrangThai(),ban.get(0).GetTenBan(),ban.get(0).GetMaBan());
                                jPanel2.removeAll();
                                jPanel2.add(goimon);
                                jPanel2.updateUI();
                            }
                        }                    
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();
            }
        }
    }
    
    private void Start(){
        if(thread==null){
            thread= new Thread(this);
            thread.start();
        }
    }
    private void Update(){
        lblTime.setText(String.valueOf(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date())));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        pnBan = new javax.swing.JPanel();
        jpBan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Total = new javax.swing.JLabel();
        btn_home = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1300, 690));

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pnBan.setBackground(new java.awt.Color(255, 255, 255));
        pnBan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jpBan.setBackground(Color.decode("#e6e6e6"));

        javax.swing.GroupLayout pnBanLayout = new javax.swing.GroupLayout(pnBan);
        pnBan.setLayout(pnBanLayout);
        pnBanLayout.setHorizontalGroup(
            pnBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBanLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnBanLayout.setVerticalGroup(
            pnBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBanLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(51, 107, 135));

        Total.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setText("Bán hàng");

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_back_arrow_50px.png"))); // NOI18N
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_home)
                .addGap(443, 443, 443)
                .addComponent(Total)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_home)
                    .addComponent(Total))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Họ tên nhân viên:");

        lbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNhanVien.setForeground(new java.awt.Color(51, 107, 135));
        lbNhanVien.setText("name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel9.setText("Ngày:");

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(51, 107, 135));
        lblDate.setText("day");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel10.setText("Thời gian:");

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(51, 107, 135));
        lblTime.setText("time");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(714, 475));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/ly-cafe.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(714, 519));
        jLabel2.setMinimumSize(new java.awt.Dimension(714, 519));
        jLabel2.setPreferredSize(new java.awt.Dimension(714, 519));
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(630, 630, 630)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(pnBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(524, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(lblDate)
                    .addComponent(lbNhanVien)
                    .addComponent(jLabel10)
                    .addComponent(lblTime))
                .addGap(0, 0, 0)
                .addComponent(pnBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(158, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detail detail= new Detail();
//                if(detail.getRoll().equals("3")){
//                   new BanHang(detail).setVisible(false);
//                   Login login = new Login();
//                   login.setVisible(true);
//                }else{
                new BanHang(detail).setVisible(true);
                }
//            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jpBan;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnBan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            Update();
            try{
                Thread.sleep(1);  
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
    }

    void updateUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
