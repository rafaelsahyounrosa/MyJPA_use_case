package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Address;
import br.com.rafaelrosa.restaurant.entity.Order;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AddressDao {

    private EntityManager entityManager;

    public AddressDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Address address) {
        this.entityManager.persist(address);
    }

    public Address find(final Long id) {
        return this.entityManager.find(Address.class, id);
    }

    public void update (final Address address){
        this.entityManager.merge(address);
    }

    public void delete(final Address address) {
        this.entityManager.remove(address);
    }

    public List<Address> findAll() {
        String query = "SELECT a FROM Address a";
        return this.entityManager.createQuery(query, Address.class).getResultList();
    }
}
