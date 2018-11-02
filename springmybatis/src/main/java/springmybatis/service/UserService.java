package springmybatis.service;


import springmybatis.domain.User;

/**
 *
 */
public interface UserService extends BaseService<User> {
    public void longTx();

}
