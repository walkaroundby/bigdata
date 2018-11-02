package entity.inheritence;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * SINGLE_TABLE     单表策略是定义继承实现的最简单有效的方法之一。 在这种方法中，多个实体类的实例仅作为属性存储在单个表中。
 * JOINED           在连接策略中，为每个实体类生成一个单独的表。 每个表的属性都与主键连接。 它消除了字段字重复的可能性。
 * TABLE_PER_CLASS  在按类表策略中，为每个子实体类生成一个单独的表。 与连接策略不同，在按类表策略中不会为父实体类生成单独的表。感觉最符合业务要求
 * @author luowei
 * @date 2018/9/6 0006 22:14
 */
@Entity
@Table
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
}
