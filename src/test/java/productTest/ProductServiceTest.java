//package productTest;
//
//import com.cjcStudying.domain.Product;
//import com.cjcStudying.service.ProductService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//public class ProductServiceTest {
//
//    @Autowired
//    ProductService productService;
//
//    /**
//     * Boolean addProduct (Product product) throws DataAccessException;
//     *
//     *     Boolean delectProduct(Product product) throws DataAccessException;
//     *
//     *     Boolean updateProduct(Product product) throws DataAccessException;
//     *
//     *     Product findProduct(String name) throws DataAccessException;
//     *
//     *     List<Product> findAllProduct() throws DataAccessException;
//     */
//
//    @Test
//    public void addProductTest(){
//        Product product = new Product();
//        product.setCid(1);
//        product.setDesc("中华第一书");
//        product.seteStorePrice(77.7);
//        product.setPid("djasdjiajo111");
//        product.setMarkPrice(900);
//        product.setPname("十万个为什么");
//        product.setpNum(14);
//        product.setImgUrl("www.baidu.com?img=123");
//
//        Boolean flag = productService.addProduct(product);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void findAllProductTest(){
//        List<Product> products = productService.findAllProduct();
//        Assert.assertNotNull(products);
//    }
//
//    @Test
//    public void updateProductTest(){
//        //Product 存在
//        Product product = new Product();
//        product.setCid(1);
//        product.setDesc("中华第一书");
//        product.seteStorePrice(77.7);
//        product.setPid("djasdjiajo111");
//        product.setMarkPrice(900);
//        product.setPname("十万个为什么");
//        product.setpNum(17);
//        product.setImgUrl("www.baidu.com?img=123");
//
//        Boolean flag = productService.updateProduct(product);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void deleteProductTest(){
//        //Product存在
//        Product product = new Product();
//        product.setCid(1);
//        product.setDesc("中华第一书");
//        product.seteStorePrice(77.7);
//        product.setPid("djasdjiajo111");
//        product.setMarkPrice(900);
//        product.setPname("十万个为什么");
//        product.setpNum(14);
//        product.setImgUrl("www.baidu.com?img=123");
//
//        Boolean flag = productService.delectProduct(product);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void updateProductTest2(){
//        //Product 不存在
//        Product product = new Product();
//        product.setCid(1);
//        product.setDesc("中华第一书");
//        product.seteStorePrice(77.7);
//        product.setPid("djasdjiajo111");
//        product.setMarkPrice(900);
//        product.setPname("十万个为什么");
//        product.setpNum(17);
//        product.setImgUrl("www.baidu.com?img=123");
//
//        Boolean flag = productService.updateProduct(product);
//        Assert.assertFalse(flag);
//    }
//
//    @Test
//    public void deleteProductTest2(){
//        //Product不存在
//        Product product = new Product();
//        product.setCid(1);
//        product.setDesc("中华第一书");
//        product.seteStorePrice(77.7);
//        product.setPid("djasdjiajo11111222");
//        product.setMarkPrice(900);
//        product.setPname("十万个为什么");
//        product.setpNum(14);
//        product.setImgUrl("www.baidu.com?img=123");
//
//        Boolean flag = productService.delectProduct(product);
//        Assert.assertFalse(flag);
//    }
//
//    @Test
//    public void findProductTest(){
//        Product product = productService.findProduct("傻瓜知道");
//        Assert.assertNotNull(product);
//    }
//
//}
