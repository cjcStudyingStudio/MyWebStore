package com.cjcStudying.dao;

import com.cjcStudying.domain.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoryDao {

    @Insert("insert into category (cid , cname) " +
            "values (#{category.cid},#{category.cname})")
    Boolean addCategory(@Param("category") Category category) throws DataAccessException;

    @Delete("delete from category where cid = #{cid}")
    Boolean deleteCategoryByCid(@Param("cid") int cid) throws DataAccessException;

    @Update("update category set cname = #{category.cname} " +
            "where cid = #{category.cid}")
    Boolean updateCategory(@Param("category") Category category) throws DataAccessException;

    @Select("select cid, cname from category")
    List<Category> findAllCategory() throws DataAccessException;

    @Select("select cname from category where cid = #{cid}")
    Category selectCategoryCnameByCid(@Param("cid")int cid);
}
