package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> list();
    void save (Product product);
    void update (Product product);
    void delete(int id);
    List<Product> search(String name);

    Product findById(int id);


}
