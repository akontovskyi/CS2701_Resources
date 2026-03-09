package com.example.demo.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
    @Column(nullable = false, updatable = false)
	@CreatedDate
	private Date Date;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="buyer")
    private User buyer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedItems> OrderedItems = new ArrayList<>();

    public Order() {}

    public Order(User buyer) {this.buyer = buyer;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getDate() {return Date;}
    public void setDate(Date date) {Date = date;}

    public User getBuyer() {return buyer;}
    public void setBuyer(User buyer) {this.buyer = buyer;}

  
}
