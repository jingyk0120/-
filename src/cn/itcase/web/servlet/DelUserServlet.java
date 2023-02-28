package cn.itcase.web.servlet;

import cn.itcase.service.UserService;
import cn.itcase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelUserServlet", value = "/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        UserService service=new UserServiceImpl();
        service.deletUser(id);
        //3.跳转到查询所有servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
