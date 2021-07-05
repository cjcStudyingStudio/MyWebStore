package com.cjcStudying.service.imp;

import com.cjcStudying.dao.ShoppingCartDao;
import com.cjcStudying.domain.ShoppingCart;
import com.cjcStudying.domain.ShoppingItems;
import com.cjcStudying.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public ShoppingCart findShoppingCart() {
        return null;
    }

    @Override
    public Boolean addShoppingCart(ShoppingCart shoppingCart) {
        Boolean flag = shoppingCartDao.insertShoppingCart(shoppingCart);
        return flag;
    }

    @Override
    public String findShoppingCartSidByUid(String uid) {
        String sid = shoppingCartDao.selectShoppingCartSidByUid(uid);
        return sid;
    }

    /**
     * 先查询有没有添加过相同的商品  如有snum+1
     * @param sid
     * @param pid
     * @return
     */
    @Override
    public Boolean addShoppingItem(String sid, String pid) {
        Boolean flag = false;
        String itemid = shoppingCartDao.selectSameProductBySidAndPid(sid,pid);
        if(itemid!=null){
            flag = shoppingCartDao.updateShoppingItemSnum(itemid);
        }else {
            ShoppingItems shoppingItems = new ShoppingItems();
            shoppingItems.setPid(pid);
            flag = shoppingCartDao.insertShoppingItem(shoppingItems,sid);
        }
        return flag;
    }
}
