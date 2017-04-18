package com.diploma.noormal.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Entity
public class Laptop {

    private Long id;
    private Producer producer;
    private Category category;
    private String model;
    private int cost;
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (cost != laptop.cost) return false;
        if (!id.equals(laptop.id)) return false;
        if (!producer.equals(laptop.producer)) return false;
        if (!model.equals(laptop.model)) return false;
        if (!image.equals(laptop.image)) return false;
        return category.equals(laptop.category);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + cost;
        result = 31 * result + image.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", producer=" + producer +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", image='" + image + '\'' +
                ", category=" + category +
                '}';
    }

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

    @ManyToOne
    @JoinColumn(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
