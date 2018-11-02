package standardQuery.duplicate;

import javax.persistence.*;
import java.util.Date;

/**
 * 没有id的抽象父类
 * @author zhangzhiyi on 2017/6/20.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    /**
     * 记录创建时间
     */
    @Column(name = "CREATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime = new Date();

    /**
     * 记录最近更新时间
     */
    @Column(name = "UPDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime = new Date();

    /**
     * 标识记录的逻辑状态，用于逻辑删除使用，禁止用作其它业务含义
     */
    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    protected Status status = Status.NORMAL;

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdateTime(new Date());
    }


}
