package com.deepakshankar.myapplication.model;

/**
 * Created by DeepakShankar on 2/6/2017.
 */

public class CartItem {
    private Product item;
    private int quantity;

    /**
     * This is the method that is used to get the item that is there in the cart.
     * @return returns the specific product form th eCart.
     */
    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
