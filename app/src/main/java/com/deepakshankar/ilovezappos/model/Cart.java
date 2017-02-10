package com.deepakshankar.ilovezappos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeepakShankar on 2/7/2017.
 */

public class Cart implements Serializable {
   public List<CartItem> items;

    public Cart(){
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
