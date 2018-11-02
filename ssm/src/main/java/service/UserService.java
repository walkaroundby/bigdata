package service;


import domain.User;

import java.util.List;

/**
 *
 */
public interface UserService extends BaseService<User> {
    void longTx();
    void save(User u);
    List<User> selectPage(int offset, int len);
}
