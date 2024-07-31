package br.com.rafaelrosa.restaurant.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders_menu_item")
public class OrdersMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private MenuItem menuItem;

    private BigDecimal price;

    private Integer quantity;

    public OrdersMenuItem() {
    }

    public OrdersMenuItem(Order order, MenuItem menuItem, Integer quantity) {
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.price = menuItem.getPrice();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
                ", order=" + order +
                ", menuItem=" + menuItem +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
