package com.example.demo.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "seller_produce")
public class SellerProduce {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produce_id")
    private Produce produce;

    private long quantity;

    private float price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedItems> OrderedItems = new ArrayList<>();
    
    public SellerProduce(){}

    public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

    public User getSeller() {return seller;}
	public void setSeller(User seller) {this.seller = seller;}

    public Produce getProduce() {return produce;}
	public void setProduce(Produce produce) {this.produce = produce;}

    public Long getQuantity() {return quantity;}
	public void setQuantity(Long quantity) {this.quantity = quantity;}

    public float getPrice() {return price;}
	public void setPrice(float price) {this.price = price;}
}
