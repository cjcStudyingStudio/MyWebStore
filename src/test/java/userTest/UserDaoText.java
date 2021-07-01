//package userTest;
//
//import com.cjcStudying.dao.UserDao;
//import com.cjcStudying.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.ParsePosition;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//public class UserDaoText {
//
//    @Autowired
//    UserDao userDao;
//
//    @Test
//    public void userDaoTest(){
//        User user = userDao.findUserByUsernameAndPassword("laowang", "123");
//        System.out.println(user);
//    }
//
//    @Test
//    public void userDaoTest2(){
//        User user = new User();
//        user.setUsername("xiaohong");
////        Date date = new Date("1990-12-19");
////        user.setBirthday(date);
//        user.setEmail("xiaohong@123.com");
//        user.setNickname("xh");
//
////        Date date1 = new Date("2021-11-2");
////        user.setUpdateTime(date1);
//        user.setPassword("123");
//        Boolean aBoolean = userDao.saveUser(user);
//        System.out.println(aBoolean);
//    }
//
//
//    @Test
//    public void userDaoTest3() throws ParseException, SQLException {
//        User user = new User();
//        user.setUsername("xiaohong");
//
////        DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   //创建一个格式化日期对象
////        Date date = simpleDateFormat.parse("1999-11-2 00:00:00");
////        Timestamp timestamp = new Timestamp(date.getTime());
////        System.out.println(timestamp);
//        user.setBirthday("1992-11-2 00:00:00");
//        user.setEmail("xiaohong@123.com");
//        user.setNickname("xxhH");
//
////        Date date2 = simpleDateFormat.parse("2021-11-2 00:00:00");
////        Timestamp timestamp2 = new Timestamp(date2.getTime());
//        user.setUpdateTime("2021-11-2 00:00:00");
//        user.setPassword("123456");
//        Boolean aBoolean = userDao.updateUser(user);
//        System.out.println(aBoolean);
//    }
//
//    /**
//     * Date 数据如何插入  ？database  使用timestamp
//     */
//    @Test
//    public void test3() throws ParseException {
//        Date date = new Date();
//        System.out.println(date);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        ParsePosition parsePosition = new ParsePosition(0);
//        String s = dateFormat.format(date);
//        System.out.println(s);
//        Date date2 = dateFormat.parse(s);
//        System.out.println(date2);
//
//        Date parse = dateFormat.parse(s, parsePosition);
//        System.out.println(parse);
//    }
//}
