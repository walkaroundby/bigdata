package domain;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author luowei
 * @date 2019-03-27 10:26
 */
@Data
@Entity
@Table(name = "t_group", schema = "hibernate")
public class Group {
    @Basic
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    /**
     * 这里的mappedBy为User类中的getGroup决定，设置fetch为eager，一的一方默认为lazy
     * @return
     */
    @OneToMany(mappedBy = "group", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

}
