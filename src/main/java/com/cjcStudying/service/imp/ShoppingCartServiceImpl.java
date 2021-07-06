package com.cjcStudying.service.imp;

import com.cjcStudying.dao.ShoppingCartDao;
import com.cjcStudying.domain.Product;
import com.cjcStudying.domain.ShoppingCart;
import com.cjcStudying.domain.ShoppingItems;
import com.cjcStudying.service.ProductService;
import com.cjcStudying.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Autowired
    private ProductService productService;


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

    @Override
    public ShoppingCart findShoppingCart(String uid) {
        List<ShoppingItems> shoppingItems = shoppingCartDao.selectShoppingCartByUid(uid);
        for (ShoppingItems s:shoppingItems
             ) {
            String pid = s.getPid();
            Product product = productService.findProductByPid(pid);
            s.setProduct(product);
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingItems(shoppingItems);
        return shoppingCart;
    }

    @Override
    public Boolean deleteItemByUidAndItemid(String uid, String itemid) {
        Boolean flag = shoppingCartDao.deleteItemByUidAndItemid(uid,itemid);
        return flag;
    }

    @Override
    public Boolean deleteShoppingCartItemByPidAndSid(String p, String sid) {
        Boolean flag = shoppingCartDao.deleteShoppingCartItemByPidAndSid(p,sid);
        return flag;
    }
}
