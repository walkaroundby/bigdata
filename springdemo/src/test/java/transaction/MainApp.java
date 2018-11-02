package transaction;

import common.StudentMarks;
import jdbc.StudentDAO;
import jdbc.StudentJDBCTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author luowei
 * @date 2018-09-28 11:09
 */
public class MainApp {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    StudentDAO studentJDBCTemplate = (StudentDAO)context.getBean("studentJDBCTemplate");

    @After
    public void afterTransaction(){
        System.out.println("------Listing all the records--------" );
        List<StudentMarks> studentMarks = studentJDBCTemplate.listStudentMarks();
        for (StudentMarks record : studentMarks) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Marks : " + record.getMarks());
            System.out.print(", Year : " + record.getYear());
            System.out.println(", Age : " + record.getAge());
        }
        System.out.println("------Records creation--------" );
    }
    @Test
    public void testProgrammingTransaction() {
        studentJDBCTemplate.create("Zara3", 11, 99, 2011);
    }

    /**
     * 声明式事务，在xml里声明事务的方法
     */
    @Test
    public void testDeclarativeTransaction(){
        studentJDBCTemplate.createTransactionControlledByXml("Zara5", 11, 99, 2010);
    }
}