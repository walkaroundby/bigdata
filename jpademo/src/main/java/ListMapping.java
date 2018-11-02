import entity.listmapping.Country;
import entity.listmapping.Province;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:54
 */
public class ListMapping {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Country country = new Country();
        country.setName("China");

        Province a = new Province();
        a.setName("Fujian");
        Province b = new Province();
        b.setName("Beijing");

        country.getProvince().add(a);
        country.getProvince().add(b);

        em.persist(country);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
