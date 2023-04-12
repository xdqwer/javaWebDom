package com.dxm.web.servlet;

import com.dxm.web.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        boolean tf=false;
        try {
            tf = userService.login(username,password);
            out.print(tf);
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        out.flush();
        out.close();
    }
}
