/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Dell
 */
public class Detail {
    String user;
    String name;
    String roll;

    public Detail() {
        user = "User1";
        name = "Chưa Đăng Nhập";
        roll = "3";
    } 

    public Detail(Detail detail){
        this.user=detail.user;
        this.name=detail.name;
        this.roll=detail.roll;
    }

    public Detail(String us, String na, String ro) {
        this.user = us;
        this.name = na;
        this.roll = ro;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String User) {
        this.user = User;
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
