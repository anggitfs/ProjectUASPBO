/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;


/**
 *
 * @author Shirogami
 */
public class CartItem extends Item {
    
    private Item item;
    private int jumlah;
    private int harga;

    public CartItem(Item item, int jumlah, int harga) {
        this.item = item;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    
    }

