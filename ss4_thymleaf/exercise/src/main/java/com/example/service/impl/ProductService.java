package com.example.service.impl;

import com.example.model.Product;

import com.example.repository.IProductRepository;
import com.example.repository.impt.ProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.list();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void update(Product product) {
        productRepository.update(product);

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);

    }

    @Override
    public void search(String name) {

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
