//package orderTest;
//
//import com.cjcStudying.dao.OrderDao;
//import com.cjcStudying.domain.Order;
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
//public class OrderDaoTest {
//
//    @Autowired
//    OrderDao orderDao;
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
//        order.setOrderTime("2021-11-2 10:44:39");
//        order.setAddress("王家湾");
//        order.setMoney(80.8);
//        order.setOid("dasdadas458");
//        order.setTel("12345678");
//        order.setRecipients("张大");
//        order.setState(1);
//        order.setUid("1");
//
//        Boolean flag = orderDao.insertOrder(order);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void updateOrderStateByIdTest(){
//        //order存在
//        Boolean flag = orderDao.updateOrderStateById("dasdadas458", 2);
//        Assert.assertTrue(flag);
//    }
//
//    @Test
//    public void updateOrderStateByIdTest2(){
//        //order不存在
//        Boolean flag = orderDao.updateOrderStateById("dasdadas4586", 2);
//        Assert.assertFalse(flag);
//    }
//
//    @Test
//    public void selectAllOrderTest(){
//        List<Order> orders = orderDao.selectAllOrder();
//        Assert.assertNotNull(orders);
//    }
//
//    //多次查询相同主键会报 PRIMARY”键的重复条目“dasdas458“
//    @Test
//    public void selectOrderByOidTest(){
//        //order存在
//        Order order = orderDao.selectOrderByOid("1232458");
//        Assert.assertNotNull(order);
//    }
//
//    @Test
//    public void selectOrderByOidTest2(){
//        //order不存在
//        Order order = orderDao.selectOrderByOid("dasdadas45811");
//        Assert.assertNull(order);
//    }
//}
