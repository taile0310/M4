package com.example.demo.dto;

import com.example.demo.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {

    private Map<ProductDto, Integer> products = new HashMap<>();

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId() == product.getId()){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(Product product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId() == product.getId()){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDto product){
        if (products.containsKey(product)) {

            Integer currentValue = products.get(product);
            products.replace(product, currentValue + 1);
        }else {
            products.put(product,1);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrices() * (float) entry.getValue();
        }
        return payment;
    }
}
