package com.cjcStudying.service.imp;

import com.cjcStudying.dao.ProductDao;
import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.SearchCondition;
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

    @Override
    public List<Product> findProductByPnameAndCidAndMinpAndMaxp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndCidAndMinpAndMaxp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPnameAndCidAndMinp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndCidAndMinp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPnameAndCidAndMaxp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndCidAndMaxp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPnameAndCid(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndCid(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPnameAndMinpAndMaxp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndMinpAndMaxp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPnameAndMinp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndMinp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPnameAndMaxp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPnameAndMaxp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByPname(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByPname(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByCidAndMinpAndMaxp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByCidAndMinpAndMaxp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByCidAndMinp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByCidAndMinp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByCidAndMaxp(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByCidAndMaxp(searchCondition);
        return products;
    }

    @Override
    public List<Product> findProductByCid(SearchCondition searchCondition) {
        List<Product> products = productDao.selectProductByCid(searchCondition);
        return products;
    }

    @Override
    public Product findProductByPid(String pid) {
        Product product = productDao.selectProductByPid(pid);
        return product;
    }
}
