package com.diploma.noormal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Arsalan. Created on 08.05.2017.
 */
@Entity
public class WishList {

    private Long id;
    private Long userId;
    private Long productId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WishList wishList = (WishList) o;

        if (!id.equals(wishList.id)) return false;
        if (!userId.equals(wishList.userId)) return false;
        return productId.equals(wishList.productId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + productId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", user=" + userId +
                ", product=" + productId +
                '}';
    }
}
