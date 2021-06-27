import com.cjcStudying.domain.User;
import com.cjcStudying.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    /**
     *      User login(String username, String password);
     *
     *     Boolean register(User user);
     *
     *     Boolean updateUser(User user);
     */

    @Autowired
    UserService userService;

    @Test
    public void loginTest1(){
        //登录成功
        User user = userService.login("laowang", "123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void loginTest2(){
        //查询失败
        User user = userService.login("laowang", "1234");
        System.out.println(user);
        Assert.assertNull(user);
    }

    @Test
    public void registerTest(){
        //注册未注册过的用户
        User user = new User();
        user.setUsername("xiaoxing");
        user.setBirthday("1994-11-2 00:00:00");
        user.setEmail("xiaoxing@123.com");
        user.setNickname("xx");
        user.setUid(3);
        user.setUpdateTime("2021-12-2 01:02:33");
        user.setPassword("123456789");

        Boolean register = userService.register(user);
        Assert.assertTrue(register);
    }

    @Test
    public void registerTest2(){
        //注册已经注册过的用户
        User user = new User();
        user.setUsername("xiaoxing");
        user.setBirthday("1994-11-2 00:00:00");
        user.setEmail("xiaoxing@123.com");
        user.setNickname("xx");
        user.setUid(3);
        user.setUpdateTime("2021-12-2 01:02:33");
        user.setPassword("123456789");

        Boolean register = userService.register(user);
        System.out.println(register);
        Assert.assertFalse(register);
    }


    @Test
    public void updateUserTest(){
        //用户有更改
        User user = new User();
        user.setUsername("xiaoxing");
        user.setBirthday("1995-11-2 00:00:00");
        user.setEmail("xiaoxing@123.com");
        user.setNickname("xx");
        user.setUid(3);
        user.setUpdateTime("2021-12-2 01:02:33");
        user.setPassword("123456789");
        Boolean flag = userService.updateUser(user);
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void updateUserTest2(){
        //用户无更改
        User user = new User();
        user.setUsername("xiaoxing");
        user.setBirthday("1995-11-2 00:00:00");
        user.setEmail("xiaoxing@123.com");
        user.setNickname("xx");
        user.setUid(3);
        user.setUpdateTime("2021-12-2 01:02:33");
        user.setPassword("123456789");
        Boolean flag = userService.updateUser(user);
        System.out.println(flag);
        Assert.assertFalse(flag);
    }
}
