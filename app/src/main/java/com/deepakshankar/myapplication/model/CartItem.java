package com.deepakshankar.myapplication.model;

import java.io.Serializable;

/**
 * Created by DeepakShankar on 2/6/2017.
 */

public class CartItem implements Serializable {
    public Product item;
    public int quantity;

    /**
     * This is the method that is used to get the item that is there in the cart.
     *
     * @return returns the specific product form th eCart.
     */
    public Product getItem() {
        return item;
    }

    /**
     * This method is used to set an item to CartItem.
     *
     * @param item
     */
    public void setItem(Product item) {
        this.item = item;
    }

    /**
     * This method is used to get the quantity of the items present in the cart for a given product.
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }



    /**
     * This method is used to set the quantity of the items present in the cart for a given product.
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return item != null ? item.equals(cartItem.item) : cartItem.item == null;

    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
