package com.cjcStudying.dao;

import com.cjcStudying.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface OrderDao {

    @Insert("insert into `order` " +
            "(oid,money,recipients,tel,address,state,ordertime,uid) " +
            "values " +
            "(#{order.oid},#{order.money},#{order.recipients},#{order.tel}," +
            "#{order.address},#{order.state},#{order.orderTime},#{order.uid})")
    Boolean insertOrder(@Param("order") Order order)throws DataAccessException;

    @Update("update `order` set state =#{state} where oid = #{oid}")
    Boolean updateOrderStateById(@Param("oid")String oid ,
                                 @Param("state")int state) throws DataAccessException;

    @Select("select oid,money,recipients,tel,address,state,ordertime,uid " +
            " from `order`")
    List<Order> selectAllOrder() throws DataAccessException;

    @Select("select oid,money,recipients,tel,address,state,ordertime,uid " +
            "from `order` where oid = #{oid}")
    Order selectOrderByOid(@Param("oid") String oid) throws DataAccessException;
}
