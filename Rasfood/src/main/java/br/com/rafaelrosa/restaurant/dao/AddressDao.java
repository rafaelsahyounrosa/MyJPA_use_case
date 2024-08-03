package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Address;
import br.com.rafaelrosa.restaurant.vo.CustomerVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

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

    public List<CustomerVo> findCustomersByAddress(final String state, final String city, final String street) {
        String query = "SELECT new br.com.rafaelrosa.restaurant.vo.CustomerVo(a.customer.cpf, a.customer.name) " +
                "FROM Address a WHERE 1=1 ";

        if(Objects.nonNull(state)){
            query = query.concat("AND UPPER(a.state) = UPPER(:state) ");
        }
        if(Objects.nonNull(city)){
            query = query.concat("AND UPPER(a.city) = UPPER(:city) ");
        }
        if(Objects.nonNull(street)){
            query = query.concat("AND UPPER(a.street) = UPPER(:street) ");
        }

        TypedQuery typedQuery = this.entityManager.createQuery(query, CustomerVo.class);

        if(Objects.nonNull(state)){
            typedQuery.setParameter("state", state);
        }
        if(Objects.nonNull(city)){
            typedQuery.setParameter("city", city);
        }
        if(Objects.nonNull(street)){
            typedQuery.setParameter("street", street);
        }

        return  typedQuery.getResultList();
    }
}
