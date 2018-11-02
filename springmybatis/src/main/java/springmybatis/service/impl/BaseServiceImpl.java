package springmybatis.service.impl;


import springmybatis.dao.BaseDao;
import springmybatis.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> dao ;

    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void insert(T t) {
        dao.insert(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void delete(Integer id) {
        dao.delete(id);
        throw new RuntimeException("出错了!!");
    }

    public T selectOne(Integer id) {
        return dao.selectOne(id);
    }

    public List<T> selectAll() {
        return dao.selectAll();
    }
}
