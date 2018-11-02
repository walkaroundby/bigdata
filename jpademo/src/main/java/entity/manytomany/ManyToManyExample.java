package entity.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * 图书馆与学生是多对多的关系。
 * 在图书馆实体类里维护学生list，标注ManyToMany
 * 在学生类里维护图书馆list，标注ManyToMany
 * 最后有3张表，TODO 查看many的情况的其他框架的最后表的个数
 * @author luowei
 * @date 2018/9/5 0005 11:31
 */
public class ManyToManyExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity_mapping");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Teacher teacher1 = new Teacher();
        teacher1.setName("Clark");
        Teacher teacher2 = new Teacher();
        teacher2.setName("Terry");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        Student student = new Student();
        student.setName("Jerry");
        student.setTeacher(teachers);
        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(student);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
