package springmybatis.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import springmybatis.dao.BaseDao;
import springmybatis.domain.User;

import java.util.List;

/**
 */
@Repository()
public class UserDaoImpl extends SqlSessionDaoSupport implements BaseDao<User> {

    public void insert(User user) {
        getSqlSession().insert("users.insert",user);
    }

    public void update(User user) {
        getSqlSession().update("users.update", user);
    }

    public void delete(Integer id ) {
        getSqlSession().delete("users.delete", id);
    }

    public User selectOne(Integer id) {
        return getSqlSession().selectOne("users.selectOne",id) ;
    }

    public List<User> selectAll() {
        return getSqlSession().selectList("users.selectAll");
    }
}
