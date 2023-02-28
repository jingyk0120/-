package cn.itcase.dao;

import cn.itcase.domain.User;

import java.util.List;
import java.util.Map;

/*
* 用户操作的Dao
* */
public interface UserDao {
    public List<User> findAll();

    void add(User user);

    void delete(int id);

    User findById(int parseInt);

    void update(User user);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每一页记录
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

//    public User findUserByUsernameAndPassword(String username,String password);

}
