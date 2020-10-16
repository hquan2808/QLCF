/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe_view;

/**
 *
 * @author Dell
 */
public class Detail {
    String User;
    String name;
    String roll;

    public Detail() {
        User = "User";
        name = "Chưa Đăng Nhập";
        roll = "3";
    } 

    public Detail(Detail detail){
        this.User=detail.User;
        this.name=detail.name;
        this.roll=detail.roll;
    }

    public Detail(String User, String name, String roll) {
        this.User = User;
        this.name = name;
        this.roll = roll;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

}
