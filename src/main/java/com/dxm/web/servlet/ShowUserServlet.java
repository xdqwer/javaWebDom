package com.dxm.web.servlet;

import com.dxm.web.entity.User;
import com.dxm.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/selectAll")
public class ShowUserServlet extends HttpServlet {
    private final   UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        try {
            List<User> users = userService.userList();
            out.print(users);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.flush();
        out.close();

    }


}
