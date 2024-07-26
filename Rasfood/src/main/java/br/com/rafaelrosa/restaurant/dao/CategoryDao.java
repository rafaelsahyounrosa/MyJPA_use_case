package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Category;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryDao {

    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(final Category category) {
        this.entityManager.persist(category);
    }

    public Category find(final Long id) {
        return this.entityManager.find(Category.class, id);
    }

    public void update (final Category category){
        this.entityManager.merge(category);
    }

    public void delete(final Category category) {
        this.entityManager.remove(category);
    }

    public List<Category> findAll() {
        String query = "SELECT c FROM Category c";
        return this.entityManager.createQuery(query, Category.class).getResultList();
    }
}
