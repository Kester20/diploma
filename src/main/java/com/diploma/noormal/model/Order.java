package com.diploma.noormal.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatusType orderStatusType;
    private String specificationStatus;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (orderStatusType != order.orderStatusType) return false;
        if (!specificationStatus.equals(order.specificationStatus)) return false;
        if (!date.equals(order.date)) return false;
        return user.equals(order.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + orderStatusType.hashCode();
        result = 31 * result + specificationStatus.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatusType=" + orderStatusType +
                ", specificationStatus='" + specificationStatus + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatusType getOrderStatusType() {
        return orderStatusType;
    }

    public void setOrderStatusType(OrderStatusType orderStatusType) {
        this.orderStatusType = orderStatusType;
    }

    public String getSpecificationStatus() {
        return specificationStatus;
    }

    public void setSpecificationStatus(String specificationStatus) {
        this.specificationStatus = specificationStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
