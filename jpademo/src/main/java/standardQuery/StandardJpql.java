package standardQuery;

import entity.manytomany.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author luowei
 * @date 2018-09-13 14:27
 */
public class StandardJpql {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Select s from Student s");

        @SuppressWarnings("unchecked")
        List<Student> list = (List<Student>)query.getResultList();
        System.out.println("Student Name :");
        for (Student s : list) {
            System.out.println(s.toString());
        }
        em.close();
        emf.close();
    }
}
