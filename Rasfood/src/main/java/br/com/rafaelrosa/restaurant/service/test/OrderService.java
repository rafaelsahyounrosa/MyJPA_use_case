package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.CustomerDao;
import br.com.rafaelrosa.restaurant.dao.MenuItemDao;
import br.com.rafaelrosa.restaurant.dao.OrderDao;
import br.com.rafaelrosa.restaurant.entity.Customer;
import br.com.rafaelrosa.restaurant.entity.Order;
import br.com.rafaelrosa.restaurant.entity.OrdersMenuItem;
import br.com.rafaelrosa.restaurant.util.DataUtil;
import br.com.rafaelrosa.restaurant.util.JPAutil;
import jakarta.persistence.EntityManager;

public class OrderService {

    public static void main(String[] args) {

        EntityManager em = JPAutil.getEntityManagerRasfood();
        em.getTransaction().begin();
        DataUtil.createCategories(em);
        DataUtil.createDishes(em);

        MenuItemDao menuItemDao = new MenuItemDao(em);
        CustomerDao customerDao = new CustomerDao(em);
        OrderDao orderDao = new OrderDao(em);

        Customer rafael = new Customer("11111111111", "Rafael", "11111111");
        Order order = new Order(rafael);
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(1), 2));
        customerDao.create(rafael);
        orderDao.create(order);
        System.out.println(order.getOrdersMenuItems());
        em.getTransaction().commit();
        em.close();
    }
}
