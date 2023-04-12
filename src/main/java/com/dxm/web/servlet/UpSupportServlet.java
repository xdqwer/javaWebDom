package com.dxm.web.servlet;

import com.dxm.web.service.SupportUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpSupport")
public class UpSupportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        SupportUpService supportUpService = new SupportUpService();
    }
}
