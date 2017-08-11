package com.realdolmen.candyshop.domain;

import javax.persistence.*;

// TODO: make entity with table "oder_line"
@Entity
@Table(name = "order_line")
public class OrderLine {
    // TODO: add id (pk, generated) and quantity (int) properties
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    // TODO: add a many to one association to candy
    @ManyToOne
    private Candy candy;

    public OrderLine() {
    }

    public OrderLine(int quantity, Candy candy) {
        this.quantity = quantity;
        this.candy = candy;
    }

    public double calculateSubTotal() {
        return candy.getPrice() * quantity;
    }


    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
