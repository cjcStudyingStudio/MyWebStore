package adminTest;

import com.cjcStudying.domain.Admin;
import com.cjcStudying.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void loginTest(){
        //账户中存在
        Admin admin = adminService.login("admin", "123");
        Assert.assertNotNull(admin);
    }

    @Test
    public void loginTest2(){
        //账户中不存在
        Admin admin = adminService.login("admin", "1234");
        Assert.assertNull(admin);
    }
}
