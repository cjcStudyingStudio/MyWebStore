package com.cjcStudying.dao;

import com.cjcStudying.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProductDao {

    @Insert("insert into `product` " +
            "(pid ,pname, estoreprice,markprice, pnum, cid, imgurl, `desc`) " +
            "values " +
            "(#{product.pid},#{product.pname},#{product.eStorePrice},#{product.markPrice}," +
            "#{product.pNum},#{product.cid},#{product.imgUrl},#{product.desc})")
    Boolean insertProduct (@Param("product") Product product) throws DataAccessException;

    @Delete("delete from `product` where pid = #{product.pid} ")
    Boolean deleteProduct(@Param("product")Product product) throws DataAccessException;

    @Update("update `product` set pname = #{product.pname} , estoreprice = #{product.eStorePrice}," +
            "markprice = #{product.markPrice}, pnum = #{product.pNum}," +
            "cid= #{product.cid}, imgurl = #{product.imgUrl}, `desc`= #{product.desc} " +
            "where pid = #{product.pid}")
    Boolean updateProduct(@Param("product")Product product) throws DataAccessException;

    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` where pname = #{name}")
    Product selectProduct(@Param("name")String name) throws DataAccessException;

    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product`")
    List<Product> selectAllProduct() throws DataAccessException;
}
