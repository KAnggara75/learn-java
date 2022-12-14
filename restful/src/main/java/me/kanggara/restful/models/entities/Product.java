package me.kanggara.restful.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "product_name")
    private String name;
    @Column(length = 500, name = "product_description")
    private String description;
    @Column(nullable = false, name = "product_price")
    private double price;

    public Product(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public double getPrice(){
        return price;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
