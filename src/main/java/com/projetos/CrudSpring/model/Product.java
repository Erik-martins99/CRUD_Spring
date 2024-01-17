package com.projetos.CrudSpring.model;

import com.projetos.CrudSpring.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(of = "id")
@Entity(name = "product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;

    public Product() {}

    public Product(String name, Integer price_in_cents) {
        this.name = name;
        this.price_in_cents = price_in_cents;
    }

    public Product(ProductDTO data) {
        this.name = data.name();
        this.price_in_cents = data.price_in_cents();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice_in_cents() {
        return price_in_cents;
    }

    public void setPrice_in_cents(Integer price_in_cents) {
        this.price_in_cents = price_in_cents;
    }
}
