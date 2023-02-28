package cn.itcase.service;
/*
* 用户管理的业务接口
* */

import cn.itcase.domain.PageBean;
import cn.itcase.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /*
    * 查询所有用户信息
    * */
    public List<User> findAll();
/*
* 保存对象
* */
    void addUser(User user);
/*
* 根据id删除
* */
    void deletUser(String id);

//    public User login(User user);


    /*
    * 根据id查询
    * */
    User findUserById(String id);
/*
* 修改用户信息
* */
    void updateUser(User user);
/*
* 删除选中的用户
* */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
