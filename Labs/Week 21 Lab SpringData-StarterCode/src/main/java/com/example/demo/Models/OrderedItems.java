package com.example.demo.Models;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ordered_items")
public class OrderedItems {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_produce_id")
    private SellerProduce sellerProduce;
    
    private long quantity;

    private float price_at_order;

    public OrderedItems(){}

    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

    public Order getOrder() {return order;}
	public void setOrder(Order order) {this.order = order;}

    public SellerProduce getSellerProduce() {return sellerProduce;}
	public void setSellerProduce(SellerProduce sellerProduce) {this.sellerProduce = sellerProduce;}

    public Long getQuantity() {return quantity;}
	public void setQuantity(Long quantity) {this.quantity = quantity;}

    public float getPriceAtOrder() {return price_at_order;}
	public void setPriceAtOrder(float price_at_order) {this.price_at_order = price_at_order;}
}
