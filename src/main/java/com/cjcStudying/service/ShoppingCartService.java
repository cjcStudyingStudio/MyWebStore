package com.cjcStudying.service;

import com.cjcStudying.domain.ShoppingCart;

public interface ShoppingCartService {
    

    Boolean addShoppingCart(ShoppingCart shoppingCart);

    String findShoppingCartSidByUid(String uid);

    Boolean addShoppingItem(String sid, String pid);

    ShoppingCart findShoppingCart(String uid);

    Boolean deleteItemByUidAndItemid(String uid, String itemid);

    Boolean deleteShoppingCartItemByPidAndSid(String p, String sid);
}
