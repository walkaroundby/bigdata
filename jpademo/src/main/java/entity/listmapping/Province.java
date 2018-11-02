package entity.listmapping;

import lombok.Data;

import javax.persistence.*;

/**
 * @author luowei
 * @date 2018/9/6 0006 20:50
 */
@Data
@Embeddable
public class Province {
    private int id;
    private String name;
}