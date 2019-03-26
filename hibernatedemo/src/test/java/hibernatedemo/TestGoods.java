package hibernatedemo;

import domain.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author luowei
 * @date 2018-09-17 21:38
 */
public class TestGoods {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();//创建配置对象
        sessionFactory = configuration.buildSessionFactory();//创建会话工厂
        session = sessionFactory.openSession();//开启会话
        transaction = session.beginTransaction();//开启事务
    }

    @After
    public void destroy() {
        //提交事务，瞬态对象转为持久态，已经被保存进数据库的实体对象，并且这个实体对象现在还处于Hibernate的缓存管理之中
        transaction.commit();

        //对象处于脱管状态，本质上和瞬时对象相同，只是比爱瞬时对象多了一个数据库记录标识值 id.
        session.close();

        sessionFactory.close();//关闭会话工厂
    }

    @Test
    public void testGoods() {
        //生成对象
        Goods goods = new Goods("女2", 2333.33);
        //保存对象进数据库
        session.save(goods);
    }
    @Test
    public void testSaveFails() {
        //生成瞬态对象，只是获得了内存空间，还未纳入hibernate的缓存
        Goods goods = new Goods("女2", 2333.33);
        //保存对象进数据库，此时还未commit
        session.save(goods);

        goods.setName("女2修改");
        // 在commit之后才生效
        session.save(goods);
        // 无效
        session.update(goods);

    }
}
