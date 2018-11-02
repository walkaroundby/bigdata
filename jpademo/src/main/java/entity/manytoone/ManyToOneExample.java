package entity.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 雇员和雇主之间是多对一的关系。
 * 在雇员里维护雇主的信息，只需要在一方维护雇主的id即可。外键关联
 * 两张表即可表明二者关系。
 * @author luowei
 * @date 2018/9/5 0005 11:16
 */
public class ManyToOneExample {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employer employer = new Employer();
        employer.setName("Tom");

        Employee employee = new Employee();
        employee.setName("Jerry");
        employee.setEmployer(employer);

        em.persist(employer);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
