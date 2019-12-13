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
public class detailPegawai extends Pegawai implements IPegawai{

    @Override
    public void Manager() {
        System.out.println("Manager Bertugas untuk menangani Pemasukkan Barang dan Karyawan");
    }

    @Override
    public void Karyawan() {
        System.out.println("Karyawan Bertugas untuk melayani Pelanggan");
    }

    @Override
    public void LakiLaki() {
        System.out.println("Jenis Kelamin : Laki-Laki");
    }

    @Override
    public void Perempuan() {
        System.out.println("Jenis Kelamin : Perempuan");
    }

    
}
