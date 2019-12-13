/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.util.List;

/**
 *
 * @author Shirogami
 */
public class Cart  {
    
   private List<CartItem> cartItems;
   private int totalHarga;

    public Cart(List<CartItem> cartItems, int totalHarga) {
        this.cartItems = cartItems;
        this.totalHarga = totalHarga;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void addItemToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public double gettotalHarga() {
        totalHarga = 0;
        cartItems.forEach((cartItem) -> {
            totalHarga += cartItem.getHarga();
        });
        return totalHarga;
    }

    public void settotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    } 
}
