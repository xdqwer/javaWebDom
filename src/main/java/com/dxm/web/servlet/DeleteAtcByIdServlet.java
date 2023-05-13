package com.dxm.web.servlet;

import com.dxm.web.service.DeleteAtcByIdService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/deleteAtcById")
public class DeleteAtcByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        int atcId = Integer.parseInt(req.getParameter("atcId"));
        DeleteAtcByIdService deleteAtcByIdService = new DeleteAtcByIdService();
        boolean tf=true;
        try {
            deleteAtcByIdService.deleteAtcByAtcId(atcId);
            out.print(tf);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
