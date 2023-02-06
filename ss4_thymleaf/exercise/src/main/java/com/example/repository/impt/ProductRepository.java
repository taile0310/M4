package com.example.repository.impt;

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
@Component
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    EntityManager entityManager;


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
    public void update(Product product) {
        Product product1 = findById(product.getId());
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

    @Transactional
    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        productList = entityManager.createQuery("FROM Product as p WHERE p.name  like :n").setParameter("n","%"+name+"%").getResultList();
        return productList;
    }

    @Transactional
    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
}
