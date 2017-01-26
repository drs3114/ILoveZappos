package com.deepakshankar.myapplication.model;

/**
 * This is a class used to store the products returned from the Zappos API.
 * Created by Deepak Shankar on 1/25/2017.
 *
 * @author Deepak Shankar
 * @version 1.0
 */

public class Product {

    private String brandName;
    private String thumbnailImageUrl;
    private int productId;
    private String originalPrice;
    private int styleId;
    private int colorId;
    private String price;
    private String percentOff;
    private String productUrl;
    private String productName;

    /**
     *
     * @return
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     *
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     *
     * @return
     */
    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    /**
     *
     * @param thumbnailImageUrl
     */
    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    /**
     *
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     *
     * @return
     */
    public String getOriginalPrice() {
        return originalPrice;
    }

    /**
     *
     * @param originalPrice
     */
    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     *
     * @return
     */
    public int getStyleId() {
        return styleId;
    }

    /**
     *
     * @param styleId
     */
    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    /**
     *
     * @return
     */
    public int getColorId() {
        return colorId;
    }

    /**
     *
     * @param colorId
     */
    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    /**
     *
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    /**
     *
     * @param productUrl
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    /**
     *
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
