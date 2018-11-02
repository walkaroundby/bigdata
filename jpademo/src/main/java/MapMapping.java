import entity.listmapping.Province;
import entity.listmapping.WestNorth;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:54
 */
public class MapMapping {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        WestNorth westNorth = new WestNorth();
        westNorth.setName("大西北");

        Province a = new Province();
        a.setName("Fujian");
        Province b = new Province();
        b.setName("Beijing");

        westNorth.getProvince().put(1,a);
        westNorth.getProvince().put(2,b);

        em.persist(westNorth);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}