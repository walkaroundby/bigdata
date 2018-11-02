package standardQuery.duplicate;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 组织的通用属性，组织包括： 学校、培训基地以及教育局
 */
@Entity
@Cacheable
@Table(name = "SYS_ORGANIZATION")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Organization extends AbstractEntity implements Serializable{
    public static final Organization NULL_ORGANIZATION = new Organization();


    public static final int GJZX = 1;
    public static final int PXJD = 2;
    public static final int JYJG = 3;
    public static final int XX = 4;

    private static final long serialVersionUID = 5615305978526804672L;

    /**
     * 记录唯一标识符
     */
    @Id
    @Column(name = "ID")
    private String id;


    private String name;
    private int type;
    private String code;
    @Column(name="parent_id")
    private String parentId;
    //父类id，使用,分隔
    @Column(name="parents_id")
    private String parentsId;
    @Column(name="custom_parent_id")
    private String customParentId;
    @Column(name="custom_parents_id")
    private String customParentsId;

    private String shen;
    private String shi;
    private String xian;

    public String getCustomParentId() {
        return customParentId;
    }

    public void setCustomParentId(String customParentId) {
        this.customParentId = customParentId;
    }

    public String getCustomParentsId() {
        return customParentsId;
    }

    public void setCustomParentsId(String customParentsId) {
        this.customParentsId = customParentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentsId() {
        return parentsId;
    }

    public void setParentsId(String parentsId) {
        this.parentsId = parentsId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShen() {
        return shen;
    }

    public void setShen(String shen) {
        this.shen = shen;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }
}
