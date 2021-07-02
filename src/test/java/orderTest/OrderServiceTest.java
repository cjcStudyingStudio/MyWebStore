//package orderTest;
//
//import com.cjcStudying.domain.Order;
//import com.cjcStudying.service.OrderService;
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
//public class OrderServiceTest {
//
//    @Autowired
//    OrderService orderService;
//
//    /**
//     *      Boolean insertOrder(@Param("order") Order order)throws DataAccessException;
//     *
//     *     Boolean updateOrderStateById(@Param("oid")String oid ,
//     *                                  @Param("state")int state) throws DataAccessException;
//     *
//     *     List<Order> selectAllOrder() throws DataAccessException;
//     *
//     *     Order selectOrderByOid(@Param("oid") String oid) throws DataAccessException;
//     */
//
//    @Test
//    public void insertOrderTest(){
//        Order order = new Order();
//        order.setOrderTime("2021-12-2 00:44:39");
//        order.setAddress("宝通寺");
//        order.setMoney(79.99);
//        order.setOid("QWEQRTT458");
//        order.setTel("12345678");
//        order.setRecipients("张小哈");
//        order.setState(1);
//        order.setUid("1");
//
//        Boolean flag = orderService.placeOrder(order);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void updateOrderStateByIdTest(){
//        //order存在
//        Boolean flag = orderService.updateOrderState("QWEQRTT458", 2);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void updateOrderStateByIdTest2(){
//        //order不存在
//        Boolean flag = orderService.updateOrderState("dasdadas4586", 2);
//        Assert.assertFalse(flag);
//    }
//
//    @Test
//    public void selectAllOrderTest(){
//        List<Order> orders = orderService.findAllOrder();
//        Assert.assertNotNull(orders);
//    }
//
//    //多次查询相同主键会报 PRIMARY”键的重复条目“dasdas458“
//    @Test
//    public void selectOrderByOidTest(){
//        //order存在
//        Order order = orderService.findOrderById("1232458");
//        Assert.assertNotNull(order);
//    }
//
//    @Test
//    public void selectOrderByOidTest2(){
//        //order不存在
//        Order order = orderService.findOrderById("dasdadas45811");
//        Assert.assertNull(order);
//    }
//}
