package com.dxm.web.servlet;

import com.dxm.web.service.InsertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        InsertService insertService = new InsertService();
        boolean tf=true;
        try {
            insertService.insert(username,password,email);
            out.print(tf);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        out.flush();
        out.close();
    }
}
