package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.CustomerDao;
import br.com.rafaelrosa.restaurant.dao.MenuItemDao;
import br.com.rafaelrosa.restaurant.dao.OrderDao;
import br.com.rafaelrosa.restaurant.entity.Address;
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

        Address address = new Address("0000000", "Street XYZ", "None", "Curitiba", "PR");
        Customer rafael = new Customer("11111111111", "Rafael");
        rafael.addAddress(address);
        Order order = new Order(rafael);
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(1), 2));
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(6), 3));
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(2), 5));
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(7), 1));
        customerDao.create(rafael);
        orderDao.create(order);



        System.out.println(orderDao.find(1L));
        System.out.println(order.getTotal());

        em.getTransaction().commit();
        em.close();
    }
}
