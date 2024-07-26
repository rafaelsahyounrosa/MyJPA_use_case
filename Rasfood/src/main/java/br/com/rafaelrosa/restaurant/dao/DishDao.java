package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Dish;
import jakarta.persistence.EntityManager;

public class DishDao {

    private EntityManager entityManager;

    public DishDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Dish dish) {
        this.entityManager.persist(dish);
        System.out.println("New Dish added: " + dish);
    }

    public Dish find(final Integer id) {
        return this.entityManager.find(Dish.class, id);
    }

    public void update(final Dish dish) {
        this.entityManager.merge(dish);
    }

    public void delete(final Dish dish) {
        this.entityManager.remove(dish);
    }
}
