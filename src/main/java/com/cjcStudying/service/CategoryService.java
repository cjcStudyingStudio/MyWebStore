package com.cjcStudying.service;

import com.cjcStudying.domain.Category;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoryService {
    Boolean addCategory(Category category) throws DataAccessException;

    Boolean deleteCategory(int cid) throws DataAccessException;

    Boolean updateCategory(Category category) throws DataAccessException;

    List<Category> findAllCategory() throws DataAccessException;

}
