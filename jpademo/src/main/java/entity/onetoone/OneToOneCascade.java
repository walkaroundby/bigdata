package entity.onetoone;

import entity.onetoone.Female;
import entity.onetoone.Male;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author luowei
 * @date 2018/9/6 0006 21:36
 */
public class OneToOneCascade {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Female female = em.find(Female.class, 5);
        em.remove(female);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
