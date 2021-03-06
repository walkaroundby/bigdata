package springmybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springmybatis.dao.BaseDao;
import springmybatis.domain.Item;
import springmybatis.domain.Order;
import springmybatis.domain.User;
import springmybatis.service.ItemService;
import springmybatis.service.UserService;

/**
 * 测试数据源
 */
public class TestItemService {
    @Test
    public void insertItem() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        BaseDao<User> dao = (BaseDao<User>)ac.getBean("userDaoImpl");
        ItemService is = (ItemService)ac.getBean("itemService");
        Item it = new Item();
        it.setItemName("ii0000");

        Order o = new Order();
        o.setId(2);

        it.setOrder(o);
        //
        is.insert(it);
    }

    @Test
    public void selectOne() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ItemService is = (ItemService)ac.getBean("itemService");
        Item it = is.selectOne(2);
        System.out.println(it.getItemName());
        System.out.println(it.getOrder().getOrderNo());
        System.out.println(it.getOrder().getUser().getName());
    }

    @Test
    public void longTx() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService)ac.getBean("userService");
        us.longTx();
    }
}
