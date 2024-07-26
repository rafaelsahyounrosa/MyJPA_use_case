package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.DishDao;
import br.com.rafaelrosa.restaurant.entity.Dish;
import br.com.rafaelrosa.restaurant.util.JPAutil;
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

        EntityManager entityManager = JPAutil.getEntityManagerRasfood();
        DishDao dishDao = new DishDao(entityManager);

        entityManager.getTransaction().begin();
        dishDao.insert(beef);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
