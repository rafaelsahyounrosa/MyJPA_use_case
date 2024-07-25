package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.entity.Dish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class DishService {

    public static void main(String[] args) {

        Dish beef = new Dish();
        beef.setName("Beef");
        beef.setDescription("Wagyu Beef");
        beef.setPrice(BigDecimal.valueOf(100.50));
        beef.setAvailable(true);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasFood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(beef);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
