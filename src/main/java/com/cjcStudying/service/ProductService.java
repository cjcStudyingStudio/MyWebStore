package com.cjcStudying.service;

import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.SearchCondition;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProductService {
    Boolean addProduct (Product product) throws DataAccessException;

    Boolean delectProduct(Product product) throws DataAccessException;

    Boolean updateProduct(Product product) throws DataAccessException;

    Product findProduct(String name) throws DataAccessException;

    List<Product> findAllProduct() throws DataAccessException;

    Boolean deleteProductByPid(String pid);

    List<Product> findProductByPnameAndCidAndMinpAndMaxp(SearchCondition searchCondition);

    List<Product> findProductByPnameAndCidAndMinp(SearchCondition searchCondition);

    List<Product> findProductByPnameAndCidAndMaxp(SearchCondition searchCondition);

    List<Product> findProductByPnameAndCid(SearchCondition searchCondition);

    List<Product> findProductByPnameAndMinpAndMaxp(SearchCondition searchCondition);

    List<Product> findProductByPnameAndMinp(SearchCondition searchCondition);

    List<Product> findProductByPnameAndMaxp(SearchCondition searchCondition);

    List<Product> findProductByPname(SearchCondition searchCondition);

    List<Product> findProductByCidAndMinpAndMaxp(SearchCondition searchCondition);

    List<Product> findProductByCidAndMinp(SearchCondition searchCondition);

    List<Product> findProductByCidAndMaxp(SearchCondition searchCondition);

    List<Product> findProductByCid(SearchCondition searchCondition);

    Product findProductByPid(String pid);
}
