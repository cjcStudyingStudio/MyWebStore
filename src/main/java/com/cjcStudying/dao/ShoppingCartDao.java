package com.cjcStudying.dao;

import com.cjcStudying.domain.ShoppingCart;
import com.cjcStudying.domain.ShoppingItems;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShoppingCartDao {

    @Insert("insert into `shoppingcart` (sid,uid)" +
            "values (#{shoppingCart.sid},#{shoppingCart.uid})")
    Boolean insertShoppingCart(@Param("shoppingCart") ShoppingCart shoppingCart);

    @Select("select `sid` from `shoppingcart` where uid = #{uid}")
    String selectShoppingCartSidByUid(@Param("uid") String uid);

    @Insert("insert into `shoppingitem`" +
            " (itemid,sid,pid) " +
            "values (#{shoppingItems.itemid},#{sid},#{shoppingItems.pid})")
    Boolean insertShoppingItem(@Param("shoppingItems") ShoppingItems shoppingItems,
                               @Param("sid")String sid);

    @Select("select `itemid` from `shoppingitem` where sid = #{sid} and pid = #{pid}")
    String selectSameProductBySidAndPid(@Param("sid")String sid,
                                        @Param("pid")String pid);

    @Update("update `shoppingitem` set snum = snum+1 where itemid = #{itemid}")
    Boolean updateShoppingItemSnum(@Param("itemid")String itemid);

    @Select("select itemid ,pid , snum from `shoppingitem` " +
            "where sid = (" +
            "select `sid` from `shoppingcart` where uid = #{uid})")
    List<ShoppingItems> selectShoppingCartByUid(@Param("uid") String uid);

    @Delete("delete from `shoppingitem` where sid = " +
            "(select sid from `shoppingcart` where uid = #{uid})" +
            " and itemid = #{itemid}")
    Boolean deleteItemByUidAndItemid(@Param("uid") String uid,
                                     @Param("itemid") String itemid);

    @Delete("delete from `shoppingitem` " +
            "where pid = #{pid} and sid = #{sid}")
    Boolean deleteShoppingCartItemByPidAndSid(@Param("pid")String p,
                                              @Param("sid")String sid);
}
