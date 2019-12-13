/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;


import item.*;

/**
 *
 * @author Shirogami
 */
public class unitTest {
    
    public static void main(String[] args) {
        Item itm1 = new Item(30,"Surya","Filter",10000);
        Item itm2 = new Item(30,"Pro Mild","Kretek",8000);

        // test insert
        itm1.addItem();
        itm2.addItem();;

        // test update
        itm2.setKategori("Filter");
        itm2.updateItem();

        // test delete
        itm2.deleteItem();

//         test select all
        for (Item i : new Item().getAll()) {
            System.out.println("Merk: " + i.getMerk() + ", Kat: " + i.getKategori());
        }

        // test search

        }
    }
    

