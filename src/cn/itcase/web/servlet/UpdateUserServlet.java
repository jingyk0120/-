package cn.itcase.web.servlet;

import cn.itcase.domain.User;
import cn.itcase.service.UserService;
import cn.itcase.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet", value = "/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.设置编码
      request.setCharacterEncoding("utf-8");
      //2.获取map
        Map<String,String[]> map=request.getParameterMap();
        //3.封装对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        //4.调用service修改
        UserService service=new UserServiceImpl();
        service.updateUser(user);
        //5.跳转到查询所有的servlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }
}
