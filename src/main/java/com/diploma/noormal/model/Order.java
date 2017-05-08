package com.diploma.noormal.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Entity
@Table(name = "`order`")
public class Order {

    private Long id;
    private OrderTypeDelivery typeDelivery;
    private OrderTypePayment typePayment;
    private OrderStatusType status;
    private Date date;
    private User user;
    private List<Product> productList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public OrderTypeDelivery getTypeDelivery() {
        return typeDelivery;
    }

    public void setTypeDelivery(OrderTypeDelivery typeDelivery) {
        this.typeDelivery = typeDelivery;
    }

    @Enumerated(EnumType.STRING)
    public OrderTypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(OrderTypePayment typePayment) {
        this.typePayment = typePayment;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (typeDelivery != order.typeDelivery) return false;
        if (typePayment != order.typePayment) return false;
        if (status != order.status) return false;
        if (!date.equals(order.date)) return false;
        if (!user.equals(order.user)) return false;
        return productList.equals(order.productList);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + typeDelivery.hashCode();
        result = 31 * result + typePayment.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + productList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", typeDelivery=" + typeDelivery +
                ", typePayment=" + typePayment +
                ", status=" + status +
                ", date=" + date +
                ", user=" + user +
                ", productList=" + productList +
                '}';
    }
}
