package br.com.rafaelrosa.restaurant.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders_menu_item")
public class OrdersMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    @Column(name = "registered_price")
    private BigDecimal registeredPrice;

    private Integer quantity;

    public OrdersMenuItem() {
    }

    public OrdersMenuItem(MenuItem menuItem, Integer quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.registeredPrice = menuItem.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public BigDecimal getRegisteredPrice() {
        return registeredPrice;
    }

    public void setRegisteredPrice(BigDecimal price) {
        this.registeredPrice = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrdersMenuItem{" +
                "id=" + id +
                ", menuItem=" + menuItem +
                ", registeredPrice=" + registeredPrice +
                ", quantity=" + quantity +
                '}';
    }
}
