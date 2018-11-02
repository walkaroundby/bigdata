package mapping;

import entity.Address;
import entity.Employee;
import entity.Employer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA的map映射
 */
public class MapMapping {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();

        System.out.println("Start work...");
        em.getTransaction().begin();

        Employer e1 = new Employer();
        e1.setE_name("Maxsu");

        e1.getAddress().put(1, new Address(1,"hh","hh"));
        e1.getAddress().put(2, new Address(2,"hh2","hh2"));
        e1.getAddress().put(3, new Address(3,"hh3","hh3"));

        em.persist(e1);
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("End work...");

    }
}