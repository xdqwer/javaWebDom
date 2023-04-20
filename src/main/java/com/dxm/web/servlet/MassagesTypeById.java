package com.dxm.web.servlet;

import com.dxm.web.entity.Massages;
import com.dxm.web.service.MassagersByIdService;
import com.dxm.web.utils.ServletJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/massagesById")
public class MassagesTypeById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MassagersByIdService massagersTypeService = new MassagersByIdService();
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        int id=Integer.parseInt(req.getParameter("id"));
        try {
            List<Massages> outMassages=massagersTypeService.massagesType(id);
            ServletJson.sendJson(resp,outMassages);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
