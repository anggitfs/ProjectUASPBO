/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pegawai;

/**
 *
 * @author Shirogami
 */
public class Bagian {
    private String spec;
    
    Bagian(){
        
    }
    
    public Bagian (String spec){
        this.spec = spec;
    }
    
    public void setSpesialis(String spesialis){
        this.spec = spec;
    }
    
    public String getSpesialis(){
        return spec;
    }
    
    public void info(){
        System.out.printf("Spesialis : %s\n", spec);
    }
}
