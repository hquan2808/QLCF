/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

import Sql.Mysql;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Hoang Quan
 */
public class ThongKe extends javax.swing.JFrame {

    /**
     * Creates new form ThongKe
     */
    private Detail detail;
    private String sql="SELECT * FROM thongke";
    private boolean leapYear=false,Year=false,Month=false,Day=false;
    public ThongKe(Detail d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        detail= new Detail(d);
        select_nam.setValue(Double.parseDouble(new SimpleDateFormat("yyyy").format(new java.util.Date())));
//        int q = Integer.parseInt(select_thang.getSelectedItem().toString());
//        System.out.println(q);
        addDays();

        loadData(sql);
        Refresh();
//        chonSearch();
    }
    private void Refresh(){
        Year=false;
        Month=false;
        Day=false;
        select_ngay.setEnabled(false);
        select_thang.setEnabled(false);
        select_nam.setEnabled(false);
//        select_thang.setSelectedIndex(0);
//        select_nam.setSelectedIndex(0);
    }
    private void chonSearch(){
        Refresh();
        if(rd_nam.isSelected()){
            select_nam.setEnabled(true);
            Year=true;
        }
        else
        if(rd_thang.isSelected()){
            select_thang.setEnabled(true);
            select_nam.setEnabled(true);
            Month=true;
        }
        else
        if(rd_ngay.isSelected()){
            select_ngay.setEnabled(true);
            select_thang.setEnabled(true);
            select_nam.setEnabled(true);
            Day=true;
        } 
    }
    private void loadData(String sql){
        int count=0;
        long tongTien=0;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try{
            String[] arry={"Nhân viên","Thời gian","Ngày","Thời gian","Tổng tiền"};
            DefaultTableModel model=new DefaultTableModel(arry,0);
            Connection conn = Mysql.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getString("tenNV").trim());
                vector.add(rs.getString("thoiGian").trim());
                vector.add(rs.getString("ngay").trim());
                vector.add(rs.getString("thoiGian").trim());
                vector.add(rs.getString("tongTien").trim()+" VNĐ");
                model.addRow(vector);
            }
            table_ThongKe.setModel(model);
            lbHoadon.setText(String.valueOf(count));
            lbTien.setText(formatter.format(tongTien)+" "+"VND");
            rs.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private double getDay(String s){
        String [] arry= s.replace("/"," ").split("\\s");
        return Double.parseDouble(arry[arry.length-3]);
    }
    private double getMonth(String s){
        String [] arry = s.replace("/"," ").split("\\s");
        return Double.parseDouble(arry[arry.length-2]);
    }
    private double getYear(String s){
        String [] arry = s.replace("/"," ").split("\\s");
        return Double.parseDouble(arry[arry.length-3]);
    }
//    private void checkYear(){
//        if(Double.parseDouble(String.valueOf(select_nam.getValue()))%4==0 && Double.parseDouble(String.valueOf(cbxYear.getValue()))%100!=0 || Double.parseDouble(String.valueOf(cbxYear.getValue()))%400==0 ){
//            leapYear=true;
//        }
//        else    leapYear=false;
//    }
    private void addDays(){
        select_ngay.setEnabled(true);
        String []day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String q = select_thang.getSelectedItem().toString();
        switch(q){
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                select_ngay.removeAllItems();
                for (String i : day) {
                    select_ngay.addItem(i);
                }
                break;
                
            case "4":
            case "6":
            case "9":
            case "11":
                select_ngay.removeAllItems();
                for (int i = 0; i <day.length ; i++) {
                    select_ngay.addItem(day[i]);
                }
                break;
            case "2":
                select_ngay.removeAllItems();
                if (leapYear == true) {
                    for (int i = 0; i < day.length-2; i++) {
                        select_ngay.addItem(day[i]);
                    }
                }else{
                    for (int i = 0; i < day.length-3; i++) {
                        select_ngay.addItem(day[i]);
                    }
                    break;
                }
                
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ThongKe = new javax.swing.JTable();
        rd_ngay = new javax.swing.JRadioButton();
        rd_thang = new javax.swing.JRadioButton();
        rd_nam = new javax.swing.JRadioButton();
        select_ngay = new javax.swing.JComboBox<>();
        select_nam = new javax.swing.JComboBox<>();
        btnReturn = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbHoadon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBieuDo = new javax.swing.JButton();
        select_thang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(table_ThongKe);

        buttonGroup1.add(rd_ngay);
        rd_ngay.setSelected(true);
        rd_ngay.setText("Xem theo ngày");
        rd_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ngayActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_thang);
        rd_thang.setText("Xem theo tháng");
        rd_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_thangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_nam);
        rd_nam.setText("Xem theo năm");
        rd_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_namActionPerformed(evt);
            }
        });

        select_ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_ngayActionPerformed(evt);
            }
        });

        jLabel1.setPreferredSize(new java.awt.Dimension(51, 20));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlyquancafe_image/home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tổng hóa đơn: ");

        lbHoadon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tổng tiền thu về: ");

        lbTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("THỐNG KÊ");

        btnBieuDo.setText("Biểu đồ");
        btnBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoActionPerformed(evt);
            }
        });

        select_thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rd_thang)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(select_thang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rd_nam)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(select_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rd_ngay)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(select_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(btnBieuDo)))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_ngay)
                            .addComponent(select_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_thang)
                            .addComponent(select_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_nam)
                            .addComponent(select_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(btnBieuDo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lbTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_ngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_select_ngayActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        quanlyquancafe_Main home = new quanlyquancafe_Main(detail);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(80, "Lương", "tháng 1");
        dataset.setValue(85, "Lương", "tháng 2");
        dataset.setValue(90, "Lương", "tháng 3");
        dataset.setValue(100, "Lương", "tháng 4");
        JFreeChart chart = ChartFactory.createBarChart("Doanh thu", "","Triệu", dataset, PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar Chart for Lương", chart);
        frame.setSize(450,350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBieuDoActionPerformed

    private void rd_ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ngayActionPerformed
        // TODO add your handling code here:
        chonSearch();
    }//GEN-LAST:event_rd_ngayActionPerformed

    private void rd_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_thangActionPerformed
        // TODO add your handling code here:
        chonSearch();
    }//GEN-LAST:event_rd_thangActionPerformed

    private void rd_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_namActionPerformed
        // TODO add your handling code here:
        chonSearch();
    }//GEN-LAST:event_rd_namActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detail detail= new Detail();
//                if(detail.getRoll().equals("3")){
//                   new ThongKe(detail).setVisible(false);
//                   Login login = new Login();
//                   login.setVisible(true);
//                }else{
                new ThongKe(detail).setVisible(true);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDo;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHoadon;
    private javax.swing.JLabel lbTien;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_ngay;
    private javax.swing.JRadioButton rd_thang;
    private javax.swing.JComboBox<String> select_nam;
    private javax.swing.JComboBox<String> select_ngay;
    private javax.swing.JComboBox<String> select_thang;
    private javax.swing.JTable table_ThongKe;
    // End of variables declaration//GEN-END:variables
}