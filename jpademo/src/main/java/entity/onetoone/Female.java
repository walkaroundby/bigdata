package entity.onetoone;

import lombok.Data;

import javax.persistence.*;

/**
 * @author luowei
 * @date 2018/9/6 0006 19:37
 */
@Entity
@Data
public class Female {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Male male;
}
