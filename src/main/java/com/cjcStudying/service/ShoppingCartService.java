package com.cjcStudying.service;

import com.cjcStudying.domain.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart findShoppingCart();

    Boolean addShoppingCart(ShoppingCart shoppingCart);

    String findShoppingCartSidByUid(String uid);

    Boolean addShoppingItem(String sid, String pid);
}
