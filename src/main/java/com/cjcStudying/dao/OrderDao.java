package com.cjcStudying.dao;

import com.cjcStudying.domain.Order;
import com.cjcStudying.domain.OrderItem;
import org.apache.ibatis.annotations.*;
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

    @Delete("delete from `order` where oid = #{oid}")
    Boolean delectOrderByOid(@Param("oid")String oid);

    @Select("select oid,money,recipients,tel,address,state,ordertime,uid " +
            "from `order` where uid = #{uid}")
    List<Order> selectOrderByUid(@Param("uid") String uid);

    @Insert("insert into `orderitem` (itemid,oid ,pid,buynum) " +
            "values " +
            "(#{orderItem.itemid},#{orderItem.oid},#{orderItem.pid}" +
            ",#{orderItem.buynum})")
    Boolean insertItem(@Param("orderItem") OrderItem orderItem);

    @Select("select itemid, oid,pid, buynum from `orderitem` where oid = #{oid}")
    List<OrderItem> selectOrderItemByOid(@Param("oid")String oid);

    @Delete("delete from `orderitem` where itemid = #{itemid}")
    Boolean deleteOrderItemByItemid(@Param("itemid")String itemid);

    @Delete("delete from `orderitem` where oid = #{oid}")
    Boolean deleteOrderItemByOid(@Param("oid")String oid);
}
