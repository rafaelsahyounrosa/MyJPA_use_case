package br.com.rafaelrosa.restaurant.dao;

import br.com.rafaelrosa.restaurant.entity.Category;
import jakarta.persistence.EntityManager;

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
}
