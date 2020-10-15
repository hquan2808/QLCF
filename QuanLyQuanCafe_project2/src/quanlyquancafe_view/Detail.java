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
//    int roll;

    public Detail() {
        User = "User";
        name = "Chưa Đăng Nhập";
    } 
    public Detail(String User, String name) {
        this.User = User;
        this.name = name;
    }

    public Detail(Detail detail){
        this.User=detail.User;
        this.name=detail.name;
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
}
