//package cn.itcase.web.servlet;
//
//import cn.itcase.domain.User;
//import cn.itcase.service.UserService;
//import cn.itcase.service.impl.UserServiceImpl;
//import org.apache.commons.beanutils.BeanUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Map;
//
//@WebServlet(name = "LoginServlet", value = "/loginServlet")
//public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.设置编码
//        request.setCharacterEncoding("utf-8");
//        //2.获取数据
//        //2.1用户填写的验证码
//        String verifycode = request.getParameter("verifycode");
//
//        //3.5验证码校验
//        HttpSession session = request.getSession();
//        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
//
//        if(!checkcode_server.equalsIgnoreCase(verifycode)){
//
//            //验证码不正确
//            request.setAttribute("login_msg","验证码错误！");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//            return;
//        }
//
//
//        Map<String,String[]> map=request.getParameterMap();
//
//        //3.封装User对象
//        User user=new User();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//        //4.调用Service查询
//        UserService service=new UserServiceImpl();
//        User loginuser=service.login(user);
//
//        //5.判断是否成功
//    }
//}
