package com.example.service.impl;

import com.example.model.Product;

import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.list();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id,Product product) {
        productRepository.update(id, product);

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);

    }

    @Override
    public List<Product> search(String name) {
return productRepository.search(name);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
