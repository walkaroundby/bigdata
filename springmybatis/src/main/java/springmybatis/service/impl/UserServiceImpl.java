package springmybatis.service.impl;

import org.springframework.stereotype.Service;
import springmybatis.dao.BaseDao;
import springmybatis.domain.Item;
import springmybatis.domain.Order;
import springmybatis.domain.User;
import springmybatis.service.UserService;

import javax.annotation.Resource;

/**
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    //
    @Resource(name = "itemDao")
    private BaseDao<Item> itemDao ;

    @Resource(name="userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }

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

        this.delete(1);
    }
}