package hibernatedemo;
import domain.Group;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

/**
 * @author luowei
 * @date 2019-03-27 10:29
 */
public class TestLazyEager {
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

    @Test
    public void testSaveGroup() {
        User user = new User();
        user.setName("u1");

        User user2 = new User();
        user2.setName("u2");
        Group group = new Group();
        group.setName("g1");
        group.getUsers().add(user);
        group.getUsers().add(user2);

        //注意，虽然两边都是级联的方式，但這裡的user也要把group设一下，不然，save(group)的时候，user表中的
        //groupId字段仍是null
        user.setGroup(group);
        user2.setGroup(group);

        session.save(group);
        transaction.commit();
    }

    @Test
    public void testLoadUser1() {
        //先seve一下，让数据库里有记录，然后测试load
        testSaveGroup();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //这条语句不会发出sql语句，只是产生一个user代理
        User user = (User) session.load(User.class, 2);
        //这句会发出两段sql语句，如下
        System.out.println(user.getGroup().getName());
        session.getTransaction().commit();

        System.out.println(user.getName());

    }

    @After
    public void afterClass() {
        sessionFactory.close();
    }
}
