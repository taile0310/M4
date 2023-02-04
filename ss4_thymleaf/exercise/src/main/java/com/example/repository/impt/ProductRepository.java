package com.example.repository.impt;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class ProductRepository implements IProductRepository {
    public static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "bông", "bông hồng", "tiệm hoa 1990", 150000));
        productList.add(new Product(2, "hoa", "hoa ly", "tiệm hoa 1990", 120000));
        productList.add(new Product(3, "cây", " cây hoa giấy", "tiệm hoa 1990", 110000));
        productList.add(new Product(4, "hoa", "hoa tu-líp", "tiệm hoa 1990", 250000));
        productList.add(new Product(5, "hoa", "hoa hướng dương", "tiệm hoa 1990", 450000));
    }

    @Override
    public List<Product> list() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (product != null){
            productList.add(product.getId(), product);
        }
    }

    @Override
    public void update(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setDescribe(product.getDescribe());
                p.setProducer(product.getProducer());
                p.setPrices(product.getPrices());
            }
        }
    }

    @Override
    public void delete(int id) {
        productList.remove(id);

    }

    @Override
    public List<Product> search(String name) {
        List<Product> list=new ArrayList<>();
        for (Product p:
             productList) {
            if(p.getName().contains(name)){
                list.add(p);
            }

        }return list;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }
}
