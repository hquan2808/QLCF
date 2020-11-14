/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Models.Detail;
import Sql_and_library.Mysql;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import quanlycafe_Banhang.BanHang;
import quanlyquancafe_QuanLy.QuanLy;
import quanlyquancafe_Thongke.ThongKe;
import quanlyquancafe_Setting.Thongtin;

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
        detail = new Detail(d);
        if(detail.getRoll().equals("Nhân viên")){
           lbqlnv.setEnabled(false);
           lbqlnv2.setEnabled(false);
           lbthongke.setEnabled(false);
           lbthongke1.setEnabled(false);
        }
    }

    public quanlyquancafe_Main() {
    }

    /**
     *
     * @param detail
     */
    
    private void setColor(JPanel panel){
        panel.setBackground(new java.awt.Color(144,175,197));
    }
    private void resetColor(JPanel panel){
        panel.setBackground(new java.awt.Color(51,107,135));
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
        pn_thongtin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_thongke = new javax.swing.JPanel();
        lbthongke = new javax.swing.JLabel();
        lbthongke1 = new javax.swing.JLabel();
        pn_banhang = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pn_QLNV = new javax.swing.JPanel();
        lbqlnv = new javax.swing.JLabel();
        lbqlnv2 = new javax.swing.JLabel();
        pn_dangxuat = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pn_thoat = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(912, 585));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 630));

        pn_thongtin.setBackground(new java.awt.Color(51, 107, 135));
        pn_thongtin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_thongtinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_thongtinMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_thongtinMousePressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_info_100px.png"))); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin");

        javax.swing.GroupLayout pn_thongtinLayout = new javax.swing.GroupLayout(pn_thongtin);
        pn_thongtin.setLayout(pn_thongtinLayout);
        pn_thongtinLayout.setHorizontalGroup(
            pn_thongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_thongtinLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pn_thongtinLayout.setVerticalGroup(
            pn_thongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongtinLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pn_thongke.setBackground(new java.awt.Color(51, 107, 135));
        pn_thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_thongkeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_thongkeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_thongkeMousePressed(evt);
            }
        });

        lbthongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_statistics_100px.png"))); // NOI18N

        lbthongke1.setForeground(new java.awt.Color(255, 255, 255));
        lbthongke1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbthongke1.setText("Thống kê");

        javax.swing.GroupLayout pn_thongkeLayout = new javax.swing.GroupLayout(pn_thongke);
        pn_thongke.setLayout(pn_thongkeLayout);
        pn_thongkeLayout.setHorizontalGroup(
            pn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbthongke1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thongkeLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lbthongke)
                .addGap(23, 23, 23))
        );
        pn_thongkeLayout.setVerticalGroup(
            pn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongkeLayout.createSequentialGroup()
                .addComponent(lbthongke)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbthongke1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pn_banhang.setBackground(new java.awt.Color(51, 107, 135));
        pn_banhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_banhangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_banhangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_banhangMousePressed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_shop_100px.png"))); // NOI18N

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Bán hàng");

        javax.swing.GroupLayout pn_banhangLayout = new javax.swing.GroupLayout(pn_banhang);
        pn_banhang.setLayout(pn_banhangLayout);
        pn_banhangLayout.setHorizontalGroup(
            pn_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_banhangLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pn_banhangLayout.setVerticalGroup(
            pn_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_banhangLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_QLNV.setBackground(new java.awt.Color(51, 107, 135));
        pn_QLNV.setPreferredSize(new java.awt.Dimension(149, 152));
        pn_QLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_QLNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_QLNVMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_QLNVMousePressed(evt);
            }
        });

        lbqlnv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbqlnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_people_100px.png"))); // NOI18N

        lbqlnv2.setForeground(new java.awt.Color(255, 255, 255));
        lbqlnv2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbqlnv2.setText("Quản lý");

        javax.swing.GroupLayout pn_QLNVLayout = new javax.swing.GroupLayout(pn_QLNV);
        pn_QLNV.setLayout(pn_QLNVLayout);
        pn_QLNVLayout.setHorizontalGroup(
            pn_QLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbqlnv2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_QLNVLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbqlnv)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pn_QLNVLayout.setVerticalGroup(
            pn_QLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLNVLayout.createSequentialGroup()
                .addComponent(lbqlnv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbqlnv2)
                .addContainerGap())
        );

        pn_dangxuat.setBackground(new java.awt.Color(51, 107, 135));
        pn_dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_dangxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_dangxuatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_dangxuatMousePressed(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_sign_out_100px.png"))); // NOI18N

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Đăng xuất");

        javax.swing.GroupLayout pn_dangxuatLayout = new javax.swing.GroupLayout(pn_dangxuat);
        pn_dangxuat.setLayout(pn_dangxuatLayout);
        pn_dangxuatLayout.setHorizontalGroup(
            pn_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_dangxuatLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel16)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pn_dangxuatLayout.setVerticalGroup(
            pn_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dangxuatLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        pn_thoat.setBackground(new java.awt.Color(51, 107, 135));
        pn_thoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_thoatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_thoatMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn_thoatMousePressed(evt);
            }
        });

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/icons8_close_window_100px.png"))); // NOI18N

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Thoát");

        javax.swing.GroupLayout pn_thoatLayout = new javax.swing.GroupLayout(pn_thoat);
        pn_thoat.setLayout(pn_thoatLayout);
        pn_thoatLayout.setHorizontalGroup(
            pn_thoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thoatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(23, 23, 23))
        );
        pn_thoatLayout.setVerticalGroup(
            pn_thoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thoatLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_QLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_thongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_banhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(pn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_QLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(pn_banhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_thongtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 107, 135));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MyCoffee");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 912, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pn_thongtinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongtinMouseEntered
        // TODO add your handling code here:
        setColor(pn_thongtin);
    }//GEN-LAST:event_pn_thongtinMouseEntered

    private void pn_banhangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_banhangMouseExited
        // TODO add your handling code here:
        resetColor(pn_banhang);
    }//GEN-LAST:event_pn_banhangMouseExited

    private void pn_thongkeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongkeMouseExited
        // TODO add your handling code here:
        resetColor(pn_thongke);
    }//GEN-LAST:event_pn_thongkeMouseExited

    private void pn_QLNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_QLNVMouseExited
        // TODO add your handling code here:
        resetColor(pn_QLNV);
    }//GEN-LAST:event_pn_QLNVMouseExited

    private void pn_dangxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dangxuatMouseExited
        // TODO add your handling code here:
        resetColor(pn_dangxuat);
    }//GEN-LAST:event_pn_dangxuatMouseExited

    private void pn_dangxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dangxuatMouseEntered
        // TODO add your handling code here:
        setColor(pn_dangxuat);
    }//GEN-LAST:event_pn_dangxuatMouseEntered

    private void pn_thongtinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongtinMouseExited
        // TODO add your handling code here:
        resetColor(pn_thongtin);
    }//GEN-LAST:event_pn_thongtinMouseExited

    private void pn_banhangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_banhangMouseEntered
        // TODO add your handling code here:
        setColor(pn_banhang);
    }//GEN-LAST:event_pn_banhangMouseEntered

    private void pn_thongkeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongkeMouseEntered
        // TODO add your handling code here:
        setColor(pn_thongke);
    }//GEN-LAST:event_pn_thongkeMouseEntered

    private void pn_QLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_QLNVMouseEntered
        // TODO add your handling code here:
        setColor(pn_QLNV);
    }//GEN-LAST:event_pn_QLNVMouseEntered

    private void pn_banhangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_banhangMousePressed
        // TODO add your handling code here:
        BanHang banhang = new BanHang(detail);
        this.setVisible(false);
        banhang.setVisible(true);
    }//GEN-LAST:event_pn_banhangMousePressed

    private void pn_thongkeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongkeMousePressed
        // TODO add your handling code here:
        ThongKe thongke = new ThongKe(detail);
        this.setVisible(false);
        thongke.setVisible(true);
    }//GEN-LAST:event_pn_thongkeMousePressed

    private void pn_QLNVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_QLNVMousePressed
        // TODO add your handling code here:
        QuanLy ql = new QuanLy(detail);
        this.setVisible(false);
        ql.setVisible(true);
    }//GEN-LAST:event_pn_QLNVMousePressed

    private void pn_thongtinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongtinMousePressed
        // TODO add your handling code here:
        Thongtin thongtin = new Thongtin(detail);
        this.setVisible(false);
        thongtin.setVisible(true);  
    }//GEN-LAST:event_pn_thongtinMousePressed

    private void pn_dangxuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_dangxuatMousePressed
        // TODO add your handling code here:
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
        }
    }//GEN-LAST:event_pn_dangxuatMousePressed

    private void pn_thoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thoatMouseEntered
        // TODO add your handling code here:
        setColor(pn_thoat);
    }//GEN-LAST:event_pn_thoatMouseEntered

    private void pn_thoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thoatMouseExited
        // TODO add your handling code here:
        resetColor(pn_thoat);
    }//GEN-LAST:event_pn_thoatMouseExited

    private void pn_thoatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thoatMousePressed
        // TODO add your handling code here:
        int click=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình hay không?", "Thông báo", 2);
        if(click==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_pn_thoatMousePressed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbqlnv;
    private javax.swing.JLabel lbqlnv2;
    private javax.swing.JLabel lbthongke;
    private javax.swing.JLabel lbthongke1;
    private javax.swing.JPanel pn_QLNV;
    private javax.swing.JPanel pn_banhang;
    private javax.swing.JPanel pn_dangxuat;
    private javax.swing.JPanel pn_thoat;
    private javax.swing.JPanel pn_thongke;
    private javax.swing.JPanel pn_thongtin;
    // End of variables declaration//GEN-END:variables
}
