package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.MenuItem;
import jakarta.persistence.EntityManager;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Collections;
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
        try {
            String query = "SELECT m FROM MenuItem m";
            return this.entityManager.createQuery(query, MenuItem.class).getResultList();
        }catch(Exception e) {
            return Collections.emptyList();
        }
    }

    public List<MenuItem> findByPrice(final BigDecimal price) {
        try {
            String query = "SELECT m FROM MenuItem m WHERE m.price = :priceParameter";
            return this.entityManager.createQuery(query, MenuItem.class).setParameter("priceParameter", price).getResultList();
        }catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public MenuItem findByName(final String name) {
        try {
            String query = "SELECT m FROM MenuItem m WHERE UPPER(m.name) = UPPER(:nameParameter)";
            return this.entityManager.createQuery(query, MenuItem.class).setParameter("nameParameter", name).getSingleResult();
        }catch (Exception e) {
            return null;
        }

    }

    public void update(final MenuItem menuItem) {
        this.entityManager.merge(menuItem);
    }

    public void delete(final MenuItem menuItem) {
        this.entityManager.remove(menuItem);
    }
}
