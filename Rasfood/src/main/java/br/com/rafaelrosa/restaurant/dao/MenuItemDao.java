package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.MenuItem;
import jakarta.persistence.EntityManager;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class MenuItemDao {

    private EntityManager entityManager;

    public MenuItemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final MenuItem menuItem) {
        this.entityManager.persist(menuItem);
//        System.out.println("New Dish added: " + dish);
    }

    public MenuItem findById(final Integer id) {
        return this.entityManager.find(MenuItem.class, id);
    }

    public List<MenuItem> findAll() {
        String query = "SELECT m FROM MenuItem m";
        return this.entityManager.createQuery(query, MenuItem.class).getResultList();
    }

    public List<MenuItem> findByPrice(final BigDecimal price) {
        String query = "SELECT m FROM MenuItem m WHERE m.price = :priceParameter";
        return this.entityManager.createQuery(query, MenuItem.class).setParameter("priceParameter", price).getResultList();
    }

    public void update(final MenuItem menuItem) {
        this.entityManager.merge(menuItem);
    }

    public void delete(final MenuItem menuItem) {
        this.entityManager.remove(menuItem);
    }
}
