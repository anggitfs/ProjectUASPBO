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
public class TestInterface {
    public static void main(String[] args) {
        detailPegawai dtp = new detailPegawai();
        
        Pegawai pg = new Pegawai();
        pg.setIdPegawai(1);
        pg.setNama("Tim Burton");
        pg.setGaji(4000000);
        dtp.Karyawan();
        dtp.LakiLaki();
        pg.info();
        
        
        
        Manager mg = new Manager();
        mg.setIdManager(1);
        mg.setNama("Lunox");
        mg.setGaji(99999999);
        dtp.Manager();
        dtp.Perempuan();
        mg.info();
        
        
        
    }
}
