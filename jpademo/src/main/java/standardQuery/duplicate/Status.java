package standardQuery.duplicate;

/**
 * <p>
 * 实体记录状态枚举
 * </p>
 *
 */
public enum Status {
    /**
     * 已删除状态
     */
    REMOVED,
    /**
     * 正常状态
     */
    NORMAL,
    /**
     * 锁定
     */
    LOCKED,
    /**
     * 初始状态
     */
    INITIAL,
    /**
     * 待审核
     */
    WAIT_CHECK,
    /**
     * 驳回
     */
    REJECT
}
