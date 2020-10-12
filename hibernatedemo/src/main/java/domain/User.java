package domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author luowei
 * @date 2019-03-27 10:27
 */
@Entity
@Data
@Table(name = "t_user")
public class User {
    private String name;
    @Id
    @GeneratedValue
    private int id;

    /**
     * 设置fetch为lazy，多的一方默认问eager
     */
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    @Basic
    private Group group;

}