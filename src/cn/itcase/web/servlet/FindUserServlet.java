package cn.itcase.web.servlet;

import cn.itcase.domain.User;
import cn.itcase.service.UserService;
import cn.itcase.service.impl.UserServiceImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FindUserServlet", value = "/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service查询
        UserService service=new UserServiceImpl();
        User user=service.findUserById(id);
        //3.将user存入requset
        request.setAttribute("user",user);
        //4.转发到update.jsp页面
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
