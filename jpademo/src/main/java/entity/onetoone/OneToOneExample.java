package entity.onetoone;

import entity.onetoone.Female;
import entity.onetoone.Male;

import javax.persistence.*;

/**
 * Male和Female是一对一的关系。
 * 如果业务需要，一方依赖另一方，Female依赖Male，在Female里维护Male的引用，外键关联。
 * @author luowei
 * @date 2018/9/5 0005 10:06
 */
public class OneToOneExample {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Male male = new Male();
        male.setName("MaleNotPersist");

        Female female = new Female();
        female.setName("FemalePersist");
        female.setMale(male);

        em.persist(female);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}