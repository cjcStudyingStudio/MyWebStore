package com.cjcStudying.service;

import com.cjcStudying.domain.Product;

import java.util.List;

public interface ProductService {
    Boolean addProduct (Product product);

    Boolean delectProduct(Product product);

    Boolean updateProduct(Product product);

    Product findProduct(String name);

    List<Product> findAllProduct();
}
