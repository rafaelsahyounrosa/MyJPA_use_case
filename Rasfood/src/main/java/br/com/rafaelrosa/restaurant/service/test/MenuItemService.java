package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.CategoryDao;
import br.com.rafaelrosa.restaurant.dao.MenuItemDao;
import br.com.rafaelrosa.restaurant.entity.Category;
import br.com.rafaelrosa.restaurant.entity.MenuItem;
import br.com.rafaelrosa.restaurant.util.JPAutil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class MenuItemService {

    public static void main(String[] args) {

        EntityManager entityManager = JPAutil.getEntityManagerRasfood();
        createMenu(entityManager, createCategory(entityManager));

    }

    private static Category createCategory(EntityManager entityManager) {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        Category mainDish = new Category("Main Dish");

        entityManager.getTransaction().begin();
        categoryDao.create(mainDish);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return mainDish;
    }

    private static void createMenu(EntityManager entityManager, Category category) {
        MenuItem beef = new MenuItem();
        beef.setName("Beef");
        beef.setDescription("Wagyu Beef");
        beef.setPrice(BigDecimal.valueOf(100.50));
        beef.setCategory(category);
        beef.setAvailable(true);

        MenuItem carbonara = new MenuItem();
        carbonara.setName("Carbonara Pasta");
        carbonara.setDescription("Carbonara Pasta");
        carbonara.setPrice(BigDecimal.valueOf(80.50));
        carbonara.setCategory(category);
        carbonara.setAvailable(true);

        MenuItemDao menuItemDao = new MenuItemDao(entityManager);

        entityManager.getTransaction().begin();

        menuItemDao.create(beef);
        entityManager.flush();
        menuItemDao.create(carbonara);
        entityManager.flush();

        System.out.println("Prato 1: " + menuItemDao.find(1));
        System.out.println("Prato 2: " + menuItemDao.find(2));

        entityManager.close();
    }
}
