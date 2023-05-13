package com.dxm.web.servlet;

import com.dxm.web.entity.User;
import com.dxm.web.service.AllUserService;
import com.dxm.web.utils.ServletJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userList")
public class AllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        AllUserService allUserService = new AllUserService();
        try {
            List<User> userList = allUserService.allUser(pageNumber);
            ServletJson.sendJson(resp,userList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
