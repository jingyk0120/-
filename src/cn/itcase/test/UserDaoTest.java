package cn.itcase.test;

import cn.itcase.dao.UserDao;
import cn.itcase.dao.impl.UserDaoImpl;
import cn.itcase.domain.User;
import org.junit.Test;

public class UserDaoTest {
    private UserDao userDao= new UserDaoImpl();
    @Test
    public void findAll(){
        for(User findAll: userDao.findAll()){
            System.out.println(findAll);
        }
    }
}
