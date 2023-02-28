package cn.itcase.web.servlet;

import cn.itcase.service.UserService;
import cn.itcase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelSelectedServlet", value = "/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.获取所有id
        String[] ids = request.getParameterValues("uid");
        //2.调用service删除
        UserService service=new UserServiceImpl();
        service.delSelectedUser(ids);
        //3.跳转查询所有servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }
}
