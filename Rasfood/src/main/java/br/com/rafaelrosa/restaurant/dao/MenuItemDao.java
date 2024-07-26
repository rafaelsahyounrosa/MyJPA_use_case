package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.MenuItem;
import jakarta.persistence.EntityManager;

public class MenuItemDao {

    private EntityManager entityManager;

    public MenuItemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final MenuItem menuItem) {
        this.entityManager.persist(menuItem);
//        System.out.println("New Dish added: " + dish);
    }

    public MenuItem find(final Integer id) {
        return this.entityManager.find(MenuItem.class, id);
    }

    public void update(final MenuItem menuItem) {
        this.entityManager.merge(menuItem);
    }

    public void delete(final MenuItem menuItem) {
        this.entityManager.remove(menuItem);
    }
}
