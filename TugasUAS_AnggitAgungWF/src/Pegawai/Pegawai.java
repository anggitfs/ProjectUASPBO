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
public class Pegawai {
    private int idPegawai;
    private String nama;
    private int gaji;
    private Bagian spec;

    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
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
    
    public Pegawai(){
    }

    public Pegawai(int idPegawai, String nama, int gaji) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.gaji = gaji;
    }
    
    public Pegawai(int idPegawai, String nama, int gaji, Bagian spec) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.gaji = gaji;
        this.spec = spec;
    }

    public Bagian getSpec() {
        return spec;
    }

    public void setSpec(Bagian spec) {
        this.spec = spec;
    }
    
    
    
    public Pegawai getById(int idPegawai) {
        Pegawai pg = new Pegawai();
        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pegawai " + " WHERE id = '" + idPegawai + "'");

        try {
            while (rs.next()) {
                pg = new Pegawai();
                pg.setIdPegawai(rs.getInt("id"));
                pg.setNama(rs.getString("nama"));
                pg.setGaji(rs.getInt("gaji"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pg;
    }

    public ArrayList<Pegawai> getAll() {
        ArrayList<Pegawai> ListPegawai = new ArrayList();

        ResultSet rs = Koneksi.selectQuery("SELECT * FROM pegawai");

        try {
            while (rs.next()) {
                Pegawai pg = new Pegawai();
                pg.setIdPegawai(rs.getInt("id"));
                pg.setNama(rs.getString("nama"));
                pg.setGaji(rs.getInt("gaji"));

                ListPegawai.add(pg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }

    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> ListPegawai = new ArrayList();

        String sql = "Select * from pegawai where " + " nama like '%" + keyword + "%' " + " or gaji like '%" + keyword + "%' ";

        ResultSet rs = Koneksi.selectQuery(sql);

        try {
            while (rs.next()) {
                Pegawai pg = new Pegawai();
                pg.setIdPegawai(rs.getInt("id"));
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
        if(getById(idPegawai).getIdPegawai() == 0){
            String SQL = "Insert into pegawai (nama,jabatan,gaji) values(" 
                    + " '" +this.nama + "', "
                    + " '" +this.gaji + "' "
                    + " )";
                    this.idPegawai = Koneksi.insertQueryGetId(SQL);
        }
    }
    
    public void update(){
        String SQL = "Update pegawai set"
                    + " nama = '" + this.nama + "', "
                    + " gaji = '" + this.gaji + "' "
                    + "Where id = '" + this.idPegawai + "'";
            Koneksi.executeQuery(SQL);
    }
    
    public void delete(){
        String SQL = "DELETE FROM pegawai WHERE id = '"+this.idPegawai+"'";
        Koneksi.executeQuery(SQL);
    }
    
    
    public void setSpec(){
        this.spec = spec;
    }
    
    public Bagian getSpec(Bagian spec){
        return spec;
    }
    
    public void info(){
        System.out.printf("Id Pegawai : %s\n", idPegawai);
        System.out.printf("Nama Pegawai : %s\n", nama);
        System.out.printf("Gaji : %s\n", gaji);
        spec.info();
    }
}
