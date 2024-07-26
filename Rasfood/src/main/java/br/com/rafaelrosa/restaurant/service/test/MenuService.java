package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.util.DataUtil;
import br.com.rafaelrosa.restaurant.util.JPAutil;
import jakarta.persistence.EntityManager;

public class MenuService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAutil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        DataUtil.createCategories(entityManager);
        DataUtil.createDishes(entityManager);
        entityManager.close();
    }
}
