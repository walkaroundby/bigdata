package entity.listmapping;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:50
 */
@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ElementCollection
    private List<Province> province = new ArrayList<>();

}