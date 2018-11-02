package standardapi;

import entity.onetoone.Female;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author luowei
 * @date 2018/9/6 0006 21:51
 */
public class StandardApi {
    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Female> cq = cb.createQuery(Female.class);
        Root<Female> female = cq.from(Female.class);
        // 设置排序规则
        cq.multiselect(female.get("id"), female.get("name"))
                .orderBy(cb.desc(female.get("male")))
                .where(cb.like(female.get("name"), "%e%"))
                .groupBy(female.get("name"))
                .having(cb.ge(female.get("id"), 2));

        CriteriaQuery<Female> select = cq.select(female);
        TypedQuery<Female> q = em.createQuery(select);
        List<Female> list = q.getResultList();

        System.out.print("id");
        System.out.print("\t name");
        System.out.println();

        for (Female s : list) {
            System.out.print(s.getId());
            System.out.print("\t" + s.getName());
            System.out.println("\t" + s.getMale().getName());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
