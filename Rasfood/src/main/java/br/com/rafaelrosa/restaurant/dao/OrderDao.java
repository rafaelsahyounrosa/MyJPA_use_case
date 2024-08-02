package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Customer;
import br.com.rafaelrosa.restaurant.entity.Order;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderDao {

    private EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Order order) {
        this.entityManager.persist(order);
    }

    public Order find(final Long id) {
        return this.entityManager.find(Order.class, id);
    }

    public void update (final Order order){
        this.entityManager.merge(order);
    }

    public void delete(final Order order) {
        this.entityManager.remove(order);
    }

    public List<Order> findAll() {
        String query = "SELECT o FROM Order o";
        return this.entityManager.createQuery(query, Order.class).getResultList();
    }

    public List<Object[]> findBestSellersTop3 () {

        String query =  "SELECT c.name, SUM(om.quantity) FROM Order o " +
                        "JOIN OrdersMenuItem om ON o.id = om.order.id " +
                        "JOIN om.menuItem c " +
                        "GROUP BY c.name " +
                        "ORDER BY om.quantity DESC limit 3";

        return this.entityManager.createQuery(query, Object[].class).getResultList();
    }
}
