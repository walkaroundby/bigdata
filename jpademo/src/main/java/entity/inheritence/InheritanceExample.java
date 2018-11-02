package entity.inheritence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 单表策略是定义继承实现的最简单有效的方法之一。 在这种方法中，多个实体类的实例仅作为属性存储在单个表中。
 * @author luowei
 * @date 2018/9/6 0006 22:20
 */
public class InheritanceExample {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        ActiveEmployee ae1 = new ActiveEmployee("李小云", 10000, 5);
        ActiveEmployee ae2 = new ActiveEmployee("张峰", 12000, 7);

        RetiredEmployee re1 = new RetiredEmployee( "王四哥", 5000, 11);
        RetiredEmployee re2 = new RetiredEmployee( "叶问顶", 4000, 12);

        em.persist(ae1);
        em.persist(ae2);

        em.persist(re1);
        em.persist(re2);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
