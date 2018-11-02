package entity.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:38
 */
@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    private List<Student> student;
}