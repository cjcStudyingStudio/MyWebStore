import com.cjcStudying.dao.UserDao;
import com.cjcStudying.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoText {

    @Autowired
    UserDao userDao;

    @Test
    public void userDaoTest(){
        User user = userDao.findUserByUsernameAndPassword("laowang", "123");
        System.out.println(user);
    }

    @Test
    public void userDaoTest2(){
        User user = new User();
        user.setUsername("xiaohong");
//        Date date = new Date("1990-12-19");
//        user.setBirthday(date);
        user.setEmail("xiaohong@123.com");
        user.setNickname("xh");
        user.setUid(2);
//        Date date1 = new Date("2021-11-2");
//        user.setUpdateTime(date1);
        user.setPassword("123");
        Boolean aBoolean = userDao.saveUser(user);
        System.out.println(aBoolean);
    }


    @Test
    public void userDaoTest3(){
        User user = new User();
        user.setUsername("xiaohong");
//        Date date = new Date("1990-12-19");
//        user.setBirthday(date);
        user.setEmail("xiaohong@123.com");
        user.setNickname("xhH");
        user.setUid(2);
//        Date date1 = new Date("2021-11-2");
//        user.setUpdateTime(date1);
        user.setPassword("123456");
        Boolean aBoolean = userDao.updateUser(user);
        System.out.println(aBoolean);
    }

    /**
     * Date 数据如何插入  ？database
     */
}
