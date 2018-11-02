package entity.onetomany;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author luowei
 * @date 2018/9/6 0006 19:56
 */
@Entity
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    /**父母对于子女来说是一对多的关系*/
    @OneToMany
    private List<Child> child;
}