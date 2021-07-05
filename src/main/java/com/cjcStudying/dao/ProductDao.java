package com.cjcStudying.dao;

import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.SearchCondition;
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
            "cid= #{product.cid}, `desc`= #{product.desc} " +
            "where pid = #{product.pid}")
    Boolean updateProduct(@Param("product")Product product) throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` where pname = #{name}")
    Product selectProduct(@Param("name")String name) throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product`")
    List<Product> selectAllProduct() throws DataAccessException;

    @Delete("delete from `product` where pid = #{pid}")
    Boolean deleteProductByPid(@Param("pid") String pid) throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname} and cid = #{searchCondition.cid} " +
            "and estoreprice >= #{searchCondition.minprice} and " +
            "estoreprice <= #{searchCondition.maxprice}")
    List<Product> selectProductByPnameAndCidAndMinpAndMaxp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname} and cid = #{searchCondition.cid} " +
            "and estoreprice >= #{searchCondition.minprice}")
    List<Product> selectProductByPnameAndCidAndMinp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname} and cid = #{searchCondition.cid} " +
            " and  estoreprice <= #{searchCondition.maxprice}")
    List<Product> selectProductByPnameAndCidAndMaxp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname} and cid = #{searchCondition.cid} "  )
    List<Product> selectProductByPnameAndCid(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname}  and estoreprice >= #{searchCondition.minprice} and " +
            "estoreprice <= #{searchCondition.maxprice}")
    List<Product> selectProductByPnameAndMinpAndMaxp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname} " +
            "and estoreprice >= #{searchCondition.minprice} ")
    List<Product> selectProductByPnameAndMinp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname} and estoreprice <= #{searchCondition.maxprice}")
    List<Product> selectProductByPnameAndMaxp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where pname = #{searchCondition.pname}  ")
    List<Product> selectProductByPname(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            " where cid = #{searchCondition.cid} " +
            "and estoreprice >= #{searchCondition.minprice} and " +
            "estoreprice <= #{searchCondition.maxprice}")
    List<Product> selectProductByCidAndMinpAndMaxp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            " where cid = #{searchCondition.cid} " +
            "and estoreprice >= #{searchCondition.minprice}  ")
    List<Product> selectProductByCidAndMinp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where   cid = #{searchCondition.cid} " +
            "and estoreprice <= #{searchCondition.maxprice}")
    List<Product> selectProductByCidAndMaxp(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;

    @Results(value = {
            @Result(column = "imgurl", property = "imgUrl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where  cid = #{searchCondition.cid}  ")
    List<Product> selectProductByCid(@Param("searchCondition")SearchCondition searchCondition)throws DataAccessException;


    @Results(value = {
            @Result(property = "imgUrl", column = "imgurl")
    })
    @Select("select pid , pname, estoreprice, markprice, pnum, cid, imgurl, `desc` " +
            "from `product` " +
            "where  pid = #{pid}")
    Product selectProductByPid(@Param("pid") String pid);
}
