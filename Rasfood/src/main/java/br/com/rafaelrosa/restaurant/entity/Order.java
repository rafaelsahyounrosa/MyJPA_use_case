package br.com.rafaelrosa.restaurant.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal total = BigDecimal.ZERO;

    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersMenuItem> ordersMenuItems = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order() {
    }

    public void addOrdersMenuItem(OrdersMenuItem ordersMenuItem) {
        ordersMenuItem.setOrder(this);
        this.ordersMenuItems.add(ordersMenuItem);

        this.total =  total.add(ordersMenuItem.getRegisteredPrice().multiply(BigDecimal.valueOf(ordersMenuItem.getQuantity())));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrdersMenuItem> getOrdersMenuItems() {
        return ordersMenuItems;
    }

    public void setOrdersMenuItems(List<OrdersMenuItem> ordersMenuItems) {
        this.ordersMenuItems = ordersMenuItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", date=" + date +
                ", customerName=" + customer.getName() +
                ", customerCPF=" + customer.getCpf() +
                ", items=" + getOrdersMenuItems() +
                '}';
    }
}
