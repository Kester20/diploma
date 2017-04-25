package com.diploma.noormal.model;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "producer", column = @Column(name = "producer")),
        @AttributeOverride(name = "model", column = @Column(name = "model")),
        @AttributeOverride(name = "cost", column = @Column(name = "cost")),
        @AttributeOverride(name = "image", column = @Column(name = "image")),})
public class Laptop extends Product {




}
