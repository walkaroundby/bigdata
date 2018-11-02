package dao;

import domain.Order;
import domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * OrderDao
 */
public class OrderDao {

    /**
     * 插入操作
     */
    public void insert(final Order order){
        DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                s.insert("orders.insert",order);
                return null ;
            }
        });
    }

    /**
     * 插入操作
     */
    public void update(final Order order){
        DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                s.update("orders.update", order);
                return null ;
            }
        });
    }

    public Order selectOneByPk(final Integer id){
        return (Order)DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                return s.selectOne("orders.selectOne",id);
            }
        });
    }

    public List<Order> selectAll(){
        return (List<Order>)DaoTemplate.execute(new MybatisCallback() {
            public Object doInMybatis(SqlSession s) {
                return s.selectList("orders.selectAll");
            }
        });
    }
}
