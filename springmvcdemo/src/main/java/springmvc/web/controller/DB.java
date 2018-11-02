package springmvc.web.controller;

import springmvc.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/9.
 */
public class DB {
    public static Map<Integer,User> tables = new HashMap<Integer, User>();
    static{
        for(int i = 1 ; i <= 15 ; i ++){
            User u = new User();
            u.setId(i);
            u.setName("tom" + i);
            u.setAge(i % 20);
            tables.put(i,u) ;
        }
    }

    /**
     *查询全部
     */
    public static List<User> findAll(){
        return new ArrayList<User>(tables.values());
    }

    /**
     * 删除
     */
    public static void delete(Integer uid){
        tables.remove(uid);
    }

    public static User select(Integer uid){
        return tables.get(uid);
    }

    /**
     * 更新
     */
    public static void update(User user){
        tables.put(user.getId(),user) ;
    }

    /**
     * 删除全部
     */
    public static void deleteAll(){
        tables.clear();
    }
}
