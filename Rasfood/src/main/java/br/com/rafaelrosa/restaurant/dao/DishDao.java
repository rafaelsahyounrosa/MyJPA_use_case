package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Dish;
import jakarta.persistence.EntityManager;

public class DishDao {

    private EntityManager entityManager;

    public DishDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Dish dish) {
        this.entityManager.persist(dish);
        System.out.println("New Dish added: " + dish);
    }
}
