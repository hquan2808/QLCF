/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Sql.Mysql;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang Quan
 */
public class quanlyquancafe_Main extends javax.swing.JFrame {
    private Detail detail;
    /**
     * 
     */

    public quanlyquancafe_Main(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        Connection conn = Mysql.getConnection();
        detail = new Detail(d);
        if(detail.getRoll().equals("Nhân viên")){
            QLDoUong_btn.setEnabled(false);
            QLNV_btn.setEnabled(false);
            jlb_QLNV.setEnabled(false);
            jlb_QLDoUong.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel(){     ImageIcon icon = new ImageIcon("src/quanlyquancafe_image/ly-cafe.jpg");     public void paintComponent(Graphics g){         Dimension d = getSize();         g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);         setOpaque(false);         super.paintComponent(g);     } };
        jPanel2 = new javax.swing.JPanel();
        QLDoUong_btn = new javax.swing.JButton();
        QLNV_btn = new javax.swing.JButton();
        BanHang_btn = new javax.swing.JButton();
        DatBan_btn = new javax.swing.JButton();
        ThongKe_btn = new javax.swing.JButton();
        ThongTin_btn = new javax.swing.JButton();
        DangXuat_btn = new javax.swing.JButton();
        Thoat_btn = new javax.swing.JButton();
        jlb_QLDoUong = new javax.swing.JLabel();
        jlb_QLNV = new javax.swing.JLabel();
        jlb_BanHang = new javax.swing.JLabel();
        jlb_DatBan = new javax.swing.JLabel();
        jlb_ThongKe = new javax.swing.JLabel();
        jlb_ThongTin = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 630));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        QLDoUong_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_local_cafe_black_24dp.png"))); // NOI18N
        QLDoUong_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        QLDoUong_btn.setPreferredSize(new java.awt.Dimension(120, 60));
        QLDoUong_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLDoUong_btnActionPerformed(evt);
            }
        });

        QLNV_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_supervised_user_circle_black_24dp.png"))); // NOI18N
        QLNV_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        QLNV_btn.setPreferredSize(new java.awt.Dimension(120, 60));
        QLNV_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLNV_btnActionPerformed(evt);
            }
        });

        BanHang_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_storefront_black_24dp.png"))); // NOI18N
        BanHang_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        BanHang_btn.setPreferredSize(new java.awt.Dimension(120, 60));
        BanHang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanHang_btnActionPerformed(evt);
            }
        });

        DatBan_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_room_service_black_24dp.png"))); // NOI18N
        DatBan_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        DatBan_btn.setPreferredSize(new java.awt.Dimension(120, 60));

        ThongKe_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_insert_chart_black_24dp.png"))); // NOI18N
        ThongKe_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        ThongKe_btn.setPreferredSize(new java.awt.Dimension(120, 60));

        ThongTin_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_info_black_24dp.png"))); // NOI18N
        ThongTin_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        ThongTin_btn.setPreferredSize(new java.awt.Dimension(120, 60));
        ThongTin_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongTin_btnActionPerformed(evt);
            }
        });

        DangXuat_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_login_black_24dp.png"))); // NOI18N
        DangXuat_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        DangXuat_btn.setPreferredSize(new java.awt.Dimension(120, 60));
        DangXuat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangXuat_btnActionPerformed(evt);
            }
        });

        Thoat_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/baseline_close_black_24dp.png"))); // NOI18N
        Thoat_btn.setMaximumSize(new java.awt.Dimension(82, 60));
        Thoat_btn.setPreferredSize(new java.awt.Dimension(120, 60));
        Thoat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Thoat_btnActionPerformed(evt);
            }
        });

        jlb_QLDoUong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_QLDoUong.setText("Quản lý đồ uống");

        jlb_QLNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_QLNV.setText("Quản lý nhân viên");

        jlb_BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_BanHang.setText("Bán hàng");

        jlb_DatBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_DatBan.setText("Đặt bàn");

        jlb_ThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_ThongKe.setText("Thống kê");

        jlb_ThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_ThongTin.setText("Thông tin");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Đăng xuất");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thoát");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(QLNV_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb_QLNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLDoUong_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_QLDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThongTin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BanHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_DatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DatBan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DangXuat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Thoat_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongKe_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BanHang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QLDoUong_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DatBan_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThongKe_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_QLDoUong)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlb_DatBan)
                        .addComponent(jlb_BanHang)
                        .addComponent(jlb_ThongKe)))
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DangXuat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thoat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QLNV_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThongTin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jlb_QLNV)
                    .addComponent(jlb_ThongTin))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MyCoffee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BanHang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanHang_btnActionPerformed
//        Banhang banhang = new Banhang(detail);
        this.setVisible(false);
//        banhang.setVisible(true);
    }//GEN-LAST:event_BanHang_btnActionPerformed

    private void QLDoUong_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLDoUong_btnActionPerformed
        QLDU qldu = new QLDU(detail);
        this.setVisible(false);
        qldu.setVisible(true);
    }//GEN-LAST:event_QLDoUong_btnActionPerformed

    private void DangXuat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangXuat_btnActionPerformed
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
        }
        
    }//GEN-LAST:event_DangXuat_btnActionPerformed

    private void Thoat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Thoat_btnActionPerformed
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_Thoat_btnActionPerformed

    private void ThongTin_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongTin_btnActionPerformed
        Thongtin thongtin = new Thongtin(detail);
        this.setVisible(false);
        thongtin.setVisible(true);    
    }//GEN-LAST:event_ThongTin_btnActionPerformed

    private void QLNV_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLNV_btnActionPerformed
        // TODO add your handling code here:
        QLNV qlnv = new QLNV(detail);
        this.setVisible(false);
        qlnv.setVisible(true);
    }//GEN-LAST:event_QLNV_btnActionPerformed

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
            java.util.logging.Logger.getLogger(quanlyquancafe_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlyquancafe_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlyquancafe_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlyquancafe_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detail detail= new Detail();
                if(detail.getRoll().equals("3")){
                   new quanlyquancafe_Main(detail).setVisible(false);
                   Login login = new Login();
                   login.setVisible(true);
                }else{
                new quanlyquancafe_Main(detail).setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BanHang_btn;
    private javax.swing.JButton DangXuat_btn;
    private javax.swing.JButton DatBan_btn;
    private javax.swing.JButton QLDoUong_btn;
    private javax.swing.JButton QLNV_btn;
    private javax.swing.JButton Thoat_btn;
    private javax.swing.JButton ThongKe_btn;
    private javax.swing.JButton ThongTin_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlb_BanHang;
    private javax.swing.JLabel jlb_DatBan;
    private javax.swing.JLabel jlb_QLDoUong;
    private javax.swing.JLabel jlb_QLNV;
    private javax.swing.JLabel jlb_ThongKe;
    private javax.swing.JLabel jlb_ThongTin;
    // End of variables declaration//GEN-END:variables
}
