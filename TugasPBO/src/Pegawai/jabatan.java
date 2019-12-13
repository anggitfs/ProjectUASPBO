/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pegawai;

import item.Koneksi;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Shirogami
 */
public class jabatan extends Pegawai{
    private String jabatan;

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
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
}
