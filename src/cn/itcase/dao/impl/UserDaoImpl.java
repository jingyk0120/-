package cn.itcase.dao.impl;

import cn.itcase.dao.UserDao;
import cn.itcase.domain.User;
import cn.itcase.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template= new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        /*
        * 使用jdbc
        * */
        String sql="select * from user";
        List<User> users=template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void add(User user) {
        //定义sql
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        //定义sql
        String sql="delete from user where id=?";
        //2.执行sql
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
        String sql="select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql；
        String sql="select count(*) from user where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key :keySet){
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value!=null&&!"".equals(value)){
                //有值
                sb.append(" and "+key+" like ?");
                params.add("%"+value+"%");//条件的值
            }
        }

        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user limit ? ,?";

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);
    }

//    @Override
//    public User findUserByUsernameAndPassword(String username, String password) {
//        try {
//            String sql="select * from user where username=? and password=?";
//            User user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class)),username,password;
//            return user;
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//
//
//    }
}
