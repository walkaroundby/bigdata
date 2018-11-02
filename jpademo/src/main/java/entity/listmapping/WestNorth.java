package entity.listmapping;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luowei
 * @date 2018/9/6 0006 21:10
 */
@Entity
@Data
public class WestNorth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ElementCollection
    private Map<Integer, Province> province = new HashMap();

}