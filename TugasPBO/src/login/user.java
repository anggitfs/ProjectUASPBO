/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import item.Koneksi;
import javax.swing.JOptionPane;

/**
 *
 * @author Shirogami
 */
public class user {
    private int idUser;
    private String email,username,password; 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
    public void login(){
           
    }
    
    public void addUser(){
        String SQL = "Insert into user (email,username,password,level) values("
                    + " '" + this.email + "', "
                    + " '" + this.username + "', "
                    + " '" + this.password + "', '2' )";
            this.idUser = Koneksi.insertQueryGetId(SQL);
    }
}
    

