package jdbc;

import common.Student;
import common.StudentMarks;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author luowei
 * @date 2018-09-28 11:05
 */
public interface StudentDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    void create(String name, Integer age);

    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
    Student getStudent(Integer id);

    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    List<Student> listStudents();
    List<StudentMarks> listStudentMarks();
    /**
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
     */
    void delete(Integer id);

    /**
     * This is the method to be used to update
     * a record into the Student table.
     */
    void update(Integer id, Integer age);

    /**
     * This is the method to be used to create
     * a record in the Student and Marks tables.
     */
    void create(String name, Integer age, Integer marks, Integer year);

    void createTransactionControlledByXml(String name, Integer age, Integer marks, Integer year);

    Student getStoredProcedure(Integer id);
}