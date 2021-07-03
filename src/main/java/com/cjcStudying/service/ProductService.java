package com.cjcStudying.service;

import com.cjcStudying.domain.Product;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProductService {
    Boolean addProduct (Product product) throws DataAccessException;

    Boolean delectProduct(Product product) throws DataAccessException;

    Boolean updateProduct(Product product) throws DataAccessException;

    Product findProduct(String name) throws DataAccessException;

    List<Product> findAllProduct() throws DataAccessException;

    Boolean deleteProductByPid(String pid);
}
