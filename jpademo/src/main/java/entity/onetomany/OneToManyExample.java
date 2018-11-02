package entity.onetomany;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

/**
 * 父母和子女之间是一对多的关系
 * 在父母类里维护一个子女list，标注@OneToMany，书本实体类里无特别注释。
 * 一对多的情况使用3张表，一对多，无法在“一”的一方里维护“多”的记录，所以要抽出一张中间表保存。
 * @author luowei
 * @date 2018/9/5 0005 11:02
 */
public class OneToManyExample {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Child a = new Child();
        a.setName("leaf-a");
        Child b = new Child();
        b.setName("leaf-b");

        ArrayList<Child> children = new ArrayList<>();
        children.add(a);
        children.add(b);

        Parent parent = new Parent();
        parent.setName("root");
        parent.setChild(children);

        em.persist(a);
        em.persist(b);
        em.persist(parent);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
