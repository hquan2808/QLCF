/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycafe_Banhang;

import quanlyquancafe_view.Login;
import quanlyquancafe_view.quanlyquancafe_Main;

/**
 *
 * @author Dell
 */
class Run {

    public static quanlyquancafe_Main QlCafe;
    public static Login frmlg;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lg();
    }

    public static void lg() {
        frmlg = new Login();
        frmlg.setVisible(true);
    }

    public static void QLCF() {
        QlCafe = new quanlyquancafe_Main();
        QlCafe.setVisible(true);
    }
}
