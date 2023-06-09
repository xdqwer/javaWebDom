package com.dxm.web.servlet;

import com.dxm.web.entity.User;
import com.dxm.web.service.UserByIdService2;
import com.dxm.web.utils.ServletJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/reqUserById2")
public class UserByIdServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        UserByIdService2 userByIdService = new UserByIdService2();
        int id = Integer.parseInt(req.getParameter("userid"));
        try {
            List<User> userList=userByIdService.reqUserById(id);
            ServletJson.sendJson(resp,userList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
