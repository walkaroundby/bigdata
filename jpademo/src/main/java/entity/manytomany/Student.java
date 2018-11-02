package entity.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:37
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    private List<Teacher> teacher;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}