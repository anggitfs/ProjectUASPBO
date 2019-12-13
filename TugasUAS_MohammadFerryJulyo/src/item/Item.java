/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Shirogami
 */
public class Item {
    private int idItem,jumlah;
    private String merk,kategori;
    private int harga;

    public Item(){
        
    }

    public Item(int jumlah, String merk, String kategori, int harga) {
        this.jumlah = jumlah;
        this.merk = merk;
        this.kategori = kategori;
        this.harga = harga;
    }
    
    
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public Item getById(int idItem) {
        Item itm = new Item();
        ResultSet rs2 = Koneksi.selectQuery("Select * from barang " + " where id = '" + idItem + "'");

        try {
            while (rs2.next()) {
                itm = new Item();
                itm.setIdItem(rs2.getInt("ID"));
                itm.setMerk(rs2.getString("Merk"));
                itm.setKategori(rs2.getString("Kategori"));
                itm.setHarga(rs2.getInt("Harga"));
                itm.setJumlah(rs2.getInt("Jumlah"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itm;
    }
    
    public ArrayList<Item> getAll() {
        ArrayList<Item> ListItem = new ArrayList();

        ResultSet rs2 = Koneksi.selectQuery("Select * from barang");

        try {
            while (rs2.next()) {
                Item itm = new Item();
                itm.setIdItem(rs2.getInt("Id"));
                itm.setMerk(rs2.getString("Merk"));
                itm.setKategori(rs2.getString("Kategori"));
                itm.setHarga(rs2.getInt("Harga"));
                itm.setJumlah(rs2.getInt("Jumlah"));

                ListItem.add(itm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListItem;
    }
    
    public void addItem() {
            String SQL = "Insert into barang (merk,kategori,harga,jumlah) values("
                    + " '" + this.merk + "', "
                    + " '" + this.kategori + "', "
                    + " '" + this.harga + "', "
                    + " '" + this.jumlah + "' "
                    + " )";
            this.idItem = Koneksi.insertQueryGetId(SQL);
        } 
    
    
    public void updateItem() {
        
            String SQL = "UPDATE barang SET "
                    + " merk = '" +this.merk +"', "
                    + " kategori = '" +this.kategori +"', "
                    + " harga = '" +this.harga +"', "
                    + " jumlah = '" +this.jumlah +"' "
                    + " WHERE id = '" +this.idItem +"'";
            Koneksi.executeQuery(SQL);
        
    }
    
    public void deleteItem() {
        String SQL = "DELETE FROM barang WHERE id = '" + this.idItem + "'";
        Koneksi.executeQuery(SQL);
    }
    
}



