package com.example.febriardis.intens;

public class Product {
    private String nm_menu;
    private int harga;
    public boolean isSelected;

    public Product(String nm_menu, int harga) {
        this.nm_menu = nm_menu;
        this.harga = harga;
    }

    public String getNm_menu() {
        return nm_menu;
    }

    public double getHarga() {
        return harga;
    }

    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {

        isSelected = selected;
    }

}
