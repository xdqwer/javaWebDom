package com.dxm.web.servlet;

import com.alibaba.fastjson.JSON;
import com.dxm.web.service.SumPageService;
import com.dxm.web.utils.ServletJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/sumPage")
public class SumPageServlet extends HotServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        SumPageService sumPageService=new SumPageService();
        PrintWriter out = resp.getWriter();
        try {
            int number=sumPageService.sumPage();
            out.print(number);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
