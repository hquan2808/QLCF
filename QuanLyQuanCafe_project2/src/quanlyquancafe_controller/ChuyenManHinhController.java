/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_controller;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import quanlyquancafe_view.TrangChuJPanel;

/**
 *
 * @author Hoang Quan
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(){
        
    }
}
