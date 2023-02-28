package cn.itcase.web.servlet;

import cn.itcase.domain.PageBean;
import cn.itcase.domain.User;
import cn.itcase.service.UserService;
import cn.itcase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "FindUserByPageServlet", value = "/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        //进行一个判断
        if (currentPage ==null||"".equals(currentPage)){
            currentPage="1";
        }
        if (rows == null || "".equals(rows)){
            rows="5";
        }

        //获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();

        //2.调用service查询
        UserService service= new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);
        //System.out.println(pb);
        //3.将PageBean存入request;
        request.setAttribute("pb",pb);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }
}
