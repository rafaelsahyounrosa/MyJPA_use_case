package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.MenuItemDao;
import br.com.rafaelrosa.restaurant.entity.MenuItem;
import br.com.rafaelrosa.restaurant.util.DataUtil;
import br.com.rafaelrosa.restaurant.util.JPAutil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class MenuService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAutil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        DataUtil.createCategories(entityManager);
        DataUtil.createDishes(entityManager);

        MenuItemDao menuDao = new MenuItemDao(entityManager);
        System.out.println("Menu items by price: " + menuDao.findByPrice(BigDecimal.valueOf(20.0)));

        entityManager.close();
    }
}
