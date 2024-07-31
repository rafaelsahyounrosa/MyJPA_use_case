package br.com.rafaelrosa.restaurant.util;

import br.com.rafaelrosa.restaurant.dao.CategoryDao;
import br.com.rafaelrosa.restaurant.dao.MenuItemDao;
import br.com.rafaelrosa.restaurant.entity.Category;
import br.com.rafaelrosa.restaurant.entity.MenuItem;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class DataUtil {


    public static void createCategories(EntityManager entityManager) {

        Category starters = new Category("Starters");
        Category mainDishes = new Category("Main Dishes");
        Category desserts = new Category("Desserts");

        CategoryDao categoryDao = new CategoryDao(entityManager);

        categoryDao.create(starters);
        entityManager.flush();
        categoryDao.create(mainDishes);
        entityManager.flush();
        categoryDao.create(desserts);
        entityManager.flush();
        entityManager.clear();
    }

    public static void createDishes(EntityManager entityManager) {

        CategoryDao categoryDao = new CategoryDao(entityManager);
        MenuItemDao menuItemDao = new MenuItemDao(entityManager);

        List<Category> categories = categoryDao.findAll();

        MenuItem beef = new MenuItem("Beef", "Wagyu Beef", true, BigDecimal.valueOf(90.50), categories.get(1));
        MenuItem salad = new MenuItem("Salad", "Simple Salad", true, BigDecimal.valueOf(20.0), categories.get(0));
        MenuItem carbonara = new MenuItem("Carbonara Pasta", "Carbonara Pasta", true, BigDecimal.valueOf(80.78), categories.get(1));
        MenuItem chocolateCake = new MenuItem("Chocolate Cake", "Chocolate Cake", true, BigDecimal.valueOf(20.0), categories.get(2));
        MenuItem salmon = new MenuItem("Salmon", "Salmon", true, BigDecimal.valueOf(80.50), categories.get(1));
        MenuItem toast = new MenuItem("French Toast", "French Toast", true, BigDecimal.valueOf(12.60), categories.get(0));
        MenuItem iceCream = new MenuItem("Vanilla Ice Cream", "Vanilla Ice Cream", true, BigDecimal.valueOf(10.0), categories.get(2));
        MenuItem fries = new MenuItem("French Fries", "French Fries", true, BigDecimal.valueOf(6.24), categories.get(0));
        MenuItem barbecue = new MenuItem("Barbecue", "Barbecue", true, BigDecimal.valueOf(60.50), categories.get(1));
        MenuItem moqueca = new MenuItem("Brazilian Moqueca", "Brazilian Moqueca", true, BigDecimal.valueOf(78.0), categories.get(1));

        menuItemDao.create(beef);
        menuItemDao.create(salad);
        menuItemDao.create(carbonara);
        menuItemDao.create(chocolateCake);
        menuItemDao.create(salmon);
        menuItemDao.create(toast);
        menuItemDao.create(iceCream);
        menuItemDao.create(fries);
        menuItemDao.create(barbecue);
        menuItemDao.create(moqueca);

        entityManager.flush();
        entityManager.clear();



    }
}
