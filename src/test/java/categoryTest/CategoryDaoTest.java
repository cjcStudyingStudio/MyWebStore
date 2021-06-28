package categoryTest;

import com.cjcStudying.dao.CategoryDao;
import com.cjcStudying.domain.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryDaoTest {
    @Autowired
    CategoryDao categoryDao;

    /**
     *      Boolean addCategory(Category category);
     *
     *     Boolean deleteCategory(int cid);
     *
     *     Boolean updateCategory(Category category);
     *
     *     List<Category> findAllCategory();
     */

    @Test
    public void addCategoryTest(){
        categoryDao.deleteCategoryByCid(12);

        Category category = new Category();
        category.setCid(12);
        category.setCname("中华小当家");

        Boolean flag = categoryDao.addCategory(category);
        Assert.assertTrue(flag);
    }

    @Test
    public void deleteCategoryTest(){
        //category存在
        Boolean flag = categoryDao.deleteCategoryByCid(12);
        Assert.assertTrue(flag);
    }

    @Test
    public void deleteCategoryTest2(){
        //category不存在
        Boolean flag = categoryDao.deleteCategoryByCid(13);
        Assert.assertFalse(flag);
    }

    @Test
    public void updateCategory(){
        Category category = new Category();
        category.setCid(12);
        category.setCname("中华小当家");
        categoryDao.addCategory(category);

        //category存在
        Category category2 = new Category();
        category2.setCid(12);
        category2.setCname("中华小当家lalala");
        Boolean flag = categoryDao.updateCategory(category2);
        Assert.assertTrue(flag);
    }

    @Test
    public void updateCategory2(){
        //category不存在
        Category category = new Category();
        category.setCid(11);
        category.setCname("中华小当家lalala");
        Boolean flag = categoryDao.updateCategory(category);
        Assert.assertFalse(flag);
    }

    @Test
    public void findAllCategoryTest(){
        List<Category> allCategory = categoryDao.findAllCategory();
//        System.out.println(allCategory);
        Assert.assertNotNull(allCategory);
    }
}
