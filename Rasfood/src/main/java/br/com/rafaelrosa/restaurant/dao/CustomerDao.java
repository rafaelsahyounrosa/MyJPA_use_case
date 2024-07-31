package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Customer;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerDao {

    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Customer customer) {
        this.entityManager.persist(customer);
    }

    public Customer find(final Long id) {
        return this.entityManager.find(Customer.class, id);
    }

    public void update (final Customer customer){
        this.entityManager.merge(customer);
    }

    public void delete(final Customer customer) {
        this.entityManager.remove(customer);
    }

    public List<Customer> findAll() {
        String query = "SELECT c FROM Customer c";
        return this.entityManager.createQuery(query, Customer.class).getResultList();
    }
}
