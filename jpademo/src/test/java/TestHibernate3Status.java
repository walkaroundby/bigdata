import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import javax.annotation.Resource;

/**
 * @author luowei
 * @date 2019-03-26 21:03
 */
public class TestHibernate3Status {
    @Resource
    private SessionFactory sessionFactory;

    @Test
    public void testInsert() {

        Session session = sessionFactory.getCurrentSession();

        Customer stu = new Customer();
        stu.setFirstName("first");
        stu.setLastName("仓");
        // 打开 Session, 开启事务
        session.save(stu);
        stu.setFirstName("second");
        // 无效
        session.save(stu);
        // 无效
        session.update(stu);
    }

}
