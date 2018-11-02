package service.impl;

import dao.BaseDao;
import domain.Item;
import domain.Order;
import domain.User;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

/**
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    //
    @Resource(name = "itemDao")
    private BaseDao<Item> itemDao ;

    /**
     * 长事务测试
     */
    public void longTx(){
        //插入item
        Item i = new Item();
        i.setItemName("ttt");

        Order o = new Order();
        o.setId(2);

        //
        itemDao.insert(i);

        this.delete(2);
    }

    public void save(User u) {
        if(u.getId() != null){
            this.update(u);
        }
        else{
            this.insert(u);
        }
    }
}