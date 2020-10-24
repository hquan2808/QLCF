/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql_and_library;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dell
 */
public class Mysql {
        public static Connection getConnection(){
            Connection connection = null;
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quancaphe?serverTimezone=UTC", "root", "");
            return connection;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }  
}
