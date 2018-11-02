package springmybatis.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import springmybatis.dao.BaseDao;
import springmybatis.domain.Order;

import java.util.List;

/**
 * OrderDao
 */
@Repository
public class OrderDaoImpl extends SqlSessionDaoSupport implements BaseDao<Order> {

    public void insert(Order order) {

    }

    public void update(Order order) {

    }

    public void delete(Integer id) {

    }

    public Order selectOne(Integer id) {
        return null;
    }

    public List<Order> selectAll() {
        return null;
    }
}