/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pegawai;

/**
 *
 * @author asus
 */
import java.util.ArrayList;
import java.sql.*;
import item.*;
public class Manager {
    private int idManager;
    private String nama;
    private int gaji;
    
    public int getIdManager(){
        return idManager;
    }

    public void setIdManager(int idManager){
        this.idManager = idManager;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGaji(){
        return gaji;
    }

    public void setGaji(int gaji){
        this.gaji= gaji;
    }
    
    public Manager(){
    }

    public Manager(int idManager, String nama, int gaji) {
        this.idManager = idManager;
        this.nama = nama;
        this.gaji = gaji;
    }
    
    public Manager getById(int idManager) {
        Manager pg = new Manager();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pegawai " + " WHERE id = '" + idManager + "'");

        try {
            while (rs.next()) {
                pg = new Manager();
                pg.setIdManager(rs.getInt("id"));
                pg.setNama(rs.getString("nama"));
                pg.setGaji(rs.getInt("gaji"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pg;
    }

    public ArrayList<Manager> getAll() {
        ArrayList<Manager> ListPegawai = new ArrayList();

        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pegawai");

        try {
            while (rs.next()) {
                Manager pg = new Manager();
                pg.setIdManager(rs.getInt("id"));
                pg.setNama(rs.getString("nama"));
                pg.setGaji(rs.getInt("gaji"));

                ListPegawai.add(pg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }

    public ArrayList<Manager> search(String keyword) {
        ArrayList<Manager> ListPegawai = new ArrayList();

        String sql = "Select * from pegawai where " + " nama like '%" + keyword + "%' " + " or gaji like '%" + keyword + "%' ";

        ResultSet rs = Koneksi.selectQuery(sql);

        try {
            while (rs.next()) {
                Manager pg = new Manager();
                pg.setIdManager(rs.getInt("id"));
                pg.setNama(rs.getString("nama"));
                pg.setGaji(rs.getInt("gaji"));

                ListPegawai.add(pg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }
    
    public void add(){
        if(getById(idManager).getIdManager() == 0){
            String SQL = "Insert into pegawai (nama,jabatan,gaji) values(" 
                    + " '" +this.nama + "', "
                    + " '" +this.gaji + "' "
                    + " )";
                    this.idManager = Koneksi.insertQueryGetId(SQL);
        }
    }
    
    public void update(){
        String SQL = "Update pegawai set"
                    + " nama = '" + this.nama + "', "
                    + " gaji = '" + this.gaji + "' "
                    + "Where id = '" + this.idManager + "'";
            Koneksi.executeQuery(SQL);
    }
    
    public void delete(){
        String SQL = "DELETE FROM pegawai WHERE id = '"+this.idManager+"'";
        Koneksi.executeQuery(SQL);
    }
    
    public void info(){
        System.out.println("ID = "+idManager +"");
        System.out.println("Nama = "+nama +"");
        System.out.println("Gaji = "+gaji +"");
    }
    
    
}
