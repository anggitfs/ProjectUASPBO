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
public class TestHasA {
    public static void main(String[] args) {
        Bagian bag = new Bagian("Bacod");
        Pegawai p = new Pegawai(3, "Fertolol", 1000);
        p.info();
        System.out.println();
        
        Bagian bag1= new Bagian();
        bag1.setSpesialis("Bacod");
        Pegawai peg1= new Pegawai();
        peg1.setNama("Fertolol");
        peg1.info();
        System.out.println();
    } 
}
