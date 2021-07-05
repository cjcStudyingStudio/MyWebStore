package productTest;

import com.cjcStudying.dao.ProductDao;
import com.cjcStudying.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    /**
     * Boolean addProduct (Product product) throws DataAccessException;
     *
     *     Boolean delectProduct(Product product) throws DataAccessException;
     *
     *     Boolean updateProduct(Product product) throws DataAccessException;
     *
     *     Product findProduct(String name) throws DataAccessException;
     *
     *     List<Product> findAllProduct() throws DataAccessException;
     */
    @Test
    public void findProductTest(){
        Product product = productDao.selectProduct("傻瓜知道");
        Assert.assertNotNull(product);
    }



    @Test
    public void addProductTest(){
        Product product = new Product();
        product.setCid(1);
        product.setDesc("中华第一书");
        product.seteStorePrice(77.7);

        product.setPid("dasdhahj11");
        product.setMarkPrice(900);
        product.setPname("十万个为什么");
        product.setpNum(14);
        product.setImgUrl("www.baidu.com?img=123");

        Boolean flag = productDao.insertProduct(product);
        Assert.assertTrue(flag);
    }

    @Test
    public void findAllProductTest(){
        List<Product> products = productDao.selectAllProduct();
        Assert.assertNotNull(products);
    }

    @Test
    public void updateProductTest(){
        //Product 存在
        Product product = new Product();
        product.setCid(1);
        product.setDesc("中华第一书");
        product.seteStorePrice(77.7);
        product.setPid("dasdhahj11");
        product.setMarkPrice(900);
        product.setPname("十万个为什么就是这样");
        product.setpNum(17);
        product.setImgUrl("www.baidu.com?img=123");

        Boolean flag = productDao.updateProduct(product);
        Assert.assertTrue(flag);
    }

    @Test
    public void deleteProductTest(){
        //Product存在
        Product product = new Product();
        product.setCid(1);
        product.setDesc("中华第一书");
        product.seteStorePrice(77.7);
        product.setPid("1");
        product.setMarkPrice(900);
        product.setPname("十万个为什么");
        product.setpNum(14);
        product.setImgUrl("www.baidu.com?img=123");

        Boolean flag = productDao.deleteProduct(product);
        Assert.assertTrue(flag);
    }

    @Test
    public void updateProductTest2(){
        //Product 不存在
        Product product = new Product();
        product.setCid(1);
        product.setDesc("中华第一书");
        product.seteStorePrice(77.7);
        product.setPid("2");
        product.setMarkPrice(900);
        product.setPname("十万个为什么");
        product.setpNum(17);
        product.setImgUrl("www.baidu.com?img=123");

        Boolean flag = productDao.updateProduct(product);
        Assert.assertFalse(flag);
    }

    @Test
    public void deleteProductTest2(){
        //Product不存在
        Product product = new Product();
        product.setCid(1);
        product.setDesc("中华第一书");
        product.seteStorePrice(77.7);
        String s1 = UUID.randomUUID().toString().replace("-", "");
        product.setPid(s1);
        product.setMarkPrice(900);
        product.setPname("十万个为什么");
        product.setpNum(14);
        product.setImgUrl("www.baidu.com?img=123");

        Boolean flag = productDao.deleteProduct(product);
        Assert.assertFalse(flag);
    }


    @Test
    public void test1(){
        Product product = productDao.selectProductByPid("25775e141c6d4b75be3e83b2a3a9b6cb");
        System.out.println(product);
    }

    @Test
    public void test2(){
        List<Product> products = productDao.selectAllProduct();
        System.out.println(products);
    }
}
