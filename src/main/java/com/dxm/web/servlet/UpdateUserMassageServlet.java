package com.dxm.web.servlet;

import com.dxm.web.entity.User;
import com.dxm.web.service.UpdateUserMassageService;
import com.dxm.web.utils.EntityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/updateUserMassage")
public class UpdateUserMassageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        EntityUtil entityUtil = new EntityUtil();
        User user = entityUtil.parseRequestToEntity(req, User.class);
        UpdateUserMassageService updateUserMassageService = new UpdateUserMassageService();
        System.out.println(user);
        boolean tf=true;
        try {
            updateUserMassageService.updateUserMassage(user);
            out.print(tf);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
