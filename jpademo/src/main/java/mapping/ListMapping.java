package mapping;

import entity.Address;
import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA列表映射
 */
public class ListMapping {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();

        System.out.println("Start work...");
        em.getTransaction().begin();

        Employee e1 = new Employee();
        e1.setE_name("Maxsu");
        e1.getAddress().add(new Address(1,"hh","hh"));
        e1.getAddress().add(new Address(2,"hh2","hh2"));
        e1.getAddress().add(new Address(3,"hh3","hh3"));

        em.persist(e1);

        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("End work...");

    }

}