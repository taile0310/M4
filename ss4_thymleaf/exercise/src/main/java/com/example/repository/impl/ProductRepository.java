package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository

public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> list() {
        List<Product> productList = new ArrayList<>();
        productList = entityManager.createQuery("FROM Product").getResultList();
        return productList;
    }

    @Transactional
    @Override
    public void save(Product product) {
        if (product != null) {
            entityManager.persist(product);
        }
    }

    @Transactional
    @Override
    public void update(int id,Product product) {
        Product product1 = findById(id);
        product1.setName(product.getName());
        product1.setDescribe(product.getDescribe());
        product1.setProducer(product.getProducer());
        product1.setPrices(product.getPrices());
        entityManager.merge(product1);

    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);

    }


    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        productList = entityManager.createQuery("FROM Product as p WHERE p.name  like :n").setParameter("n","%"+name+"%").getResultList();
        return productList;
    }


    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
}
