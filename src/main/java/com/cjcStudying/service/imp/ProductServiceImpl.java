package com.cjcStudying.service.imp;

import com.cjcStudying.dao.ProductDao;
import com.cjcStudying.domain.Product;
import com.cjcStudying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Boolean addProduct(Product product) throws DataAccessException {
        Boolean flag = productDao.insertProduct(product);
        return flag;
    }

    @Override
    public Boolean delectProduct(Product product) throws DataAccessException{
        Boolean flag = productDao.deleteProduct(product);
        return flag;
    }

    @Override
    public Boolean updateProduct(Product product) throws DataAccessException{
        Boolean flag = productDao.updateProduct(product);
        return flag;
    }

    @Override
    public Product findProduct(String name) throws DataAccessException{
        Product product = productDao.selectProduct(name);
        return product;
    }

    @Override
    public List<Product> findAllProduct() throws DataAccessException{
        List<Product> products = productDao.selectAllProduct();
        return products;
    }

    @Override
    public Boolean deleteProductByPid(String pid) {
        Boolean flag = productDao.deleteProductByPid(pid);
        return flag;
    }
}
