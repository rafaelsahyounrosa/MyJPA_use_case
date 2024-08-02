package br.com.rafaelrosa.restaurant.service.test;

import br.com.rafaelrosa.restaurant.dao.AddressDao;
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
        AddressDao addressDao = new AddressDao(em);

        Address address = new Address("0000000", "Street XYZ", "None", "Curitiba", "PR");
        Address address2 = new Address("0000001", "Street XYZ", "None", "Curitiba", "PR");
        Address address3 = new Address("0000002", "Street XZ", "None", "Rio de Janeiro", "RJ");

        Customer rafael = new Customer("11111111111", "Rafael Rosa");
        Customer yasminn = new Customer("11111111112", "Yasminn Canella");
        Customer leonardo = new Customer("11111111113", "Leonardo Rosa");

        rafael.addAddress(address);
        yasminn.addAddress(address2);
        leonardo.addAddress(address3);

        Order order = new Order(rafael);
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(1), 2));
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(6), 3));
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(2), 5));
        order.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(7), 1));
        customerDao.create(rafael);
        orderDao.create(order);

        Order order2 = new Order(yasminn);
        order2.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(1), 2));
        customerDao.create(yasminn);
        orderDao.create(order2);

        Order order3 = new Order(leonardo);
        order3.addOrdersMenuItem(new OrdersMenuItem(menuItemDao.findById(9), 1));
        customerDao.create(leonardo);
        orderDao.create(order3);



        System.out.println(addressDao.findCustomersByAddress("pr", "curitiba", "street xyz"));


        em.getTransaction().commit();
        em.close();
    }
}
