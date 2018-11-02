package entity.manytoone;

import lombok.Data;

import javax.persistence.*;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:15
 */
@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Employer employer;
}