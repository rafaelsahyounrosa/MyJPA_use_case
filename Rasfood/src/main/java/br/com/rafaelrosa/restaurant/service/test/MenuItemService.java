package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.MenuItemDao;
import br.com.rafaelrosa.restaurant.entity.MenuItem;
import br.com.rafaelrosa.restaurant.util.JPAutil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class MenuItemService {

    public static void main(String[] args) {

        MenuItem beef = new MenuItem();
        beef.setName("Beef");
        beef.setDescription("Wagyu Beef");
        beef.setPrice(BigDecimal.valueOf(100.50));
        beef.setAvailable(true);

        MenuItem carbonara = new MenuItem();
        carbonara.setName("Carbonara Pasta");
        carbonara.setDescription("Carbonara Pasta");
        carbonara.setPrice(BigDecimal.valueOf(80.50));
        carbonara.setAvailable(true);

        EntityManager entityManager = JPAutil.getEntityManagerRasfood();
        MenuItemDao menuItemDao = new MenuItemDao(entityManager);

        entityManager.getTransaction().begin();

        menuItemDao.create(beef);
        entityManager.flush();
        menuItemDao.create(carbonara);
        entityManager.flush();

        System.out.println("Prato 1: " + menuItemDao.find(1));

        menuItemDao.delete(carbonara);
        System.out.println("Prato 2: " + menuItemDao.find(2));

        entityManager.clear();
        beef.setPrice(BigDecimal.valueOf(90.65));
        menuItemDao.update(beef);
        entityManager.flush();

        System.out.println("Prato 1: " + menuItemDao.find(1));
    }
}
