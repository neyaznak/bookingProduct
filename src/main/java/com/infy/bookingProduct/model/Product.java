package com.infy.bookingProduct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

    private int code;
    private String name;
    private String description;
    private String category;
    private float mrp;
    private String imageUrl;
    private String registrationDate;

    public Product() {
    }

    private Product(int code, String name, String description, String category, float mrp, String imageUrl, String registrationDate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.mrp = mrp;
        this.imageUrl = imageUrl;
        this.registrationDate = registrationDate;
    }


    @Id
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "mrp", nullable = false)
    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    @Column(name = "imageUrl", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "registrationDate", nullable = false)
    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", mrp=" + mrp +
                ", imageUrl='" + imageUrl + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
