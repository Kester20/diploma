package com.diploma.noormal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Arsalan. Created on 23.04.2017.
 */
@Entity
public class Product {

    private Long id;
    private Producer producer;
    private String model;
    private int cost;
    private String image;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "producer")
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (cost != product.cost) return false;
        if (!id.equals(product.id)) return false;
        if (!producer.equals(product.producer)) return false;
        if (!model.equals(product.model)) return false;
        return image.equals(product.image);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + cost;
        result = 31 * result + image.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", producer=" + producer +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", image='" + image + '\'' +
                '}';
    }
}
