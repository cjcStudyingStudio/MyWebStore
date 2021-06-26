package com.cjcStudying.service;

import com.cjcStudying.domain.Category;

import java.util.List;

public interface CategoryService {
    Boolean addCategory(Category category);

    Boolean deleteCategory(int cid);

    Boolean updateCategory(Category category);

    List<Category> findAllCategory();
}
