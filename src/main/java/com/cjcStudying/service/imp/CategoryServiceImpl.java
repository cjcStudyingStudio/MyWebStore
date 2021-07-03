package com.cjcStudying.service.imp;

import com.cjcStudying.dao.CategoryDao;
import com.cjcStudying.domain.Category;
import com.cjcStudying.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public Boolean addCategory(Category category) throws DataAccessException {
        Boolean flag = categoryDao.addCategory(category);
        return flag;
    }

    @Override
    public Boolean deleteCategory(int cid) throws DataAccessException{
        Boolean flag = categoryDao.deleteCategoryByCid(cid);
        return flag;
    }

    @Override
    public Boolean updateCategory(Category category) throws DataAccessException{
        Boolean flag = categoryDao.updateCategory(category);
        return flag;
    }

    @Override
    public List<Category> findAllCategory() throws DataAccessException{
        List<Category> categories = categoryDao.findAllCategory();
        return categories;
    }

}
