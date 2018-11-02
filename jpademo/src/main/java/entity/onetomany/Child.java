package entity.onetomany;

import lombok.Data;

import javax.persistence.*;

/**
 * @author luowei
 * @date 2018/9/6 0006 19:57
 */
@Entity
@Data
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}