package com.dxm.web.servlet;


import com.dxm.web.entity.Massages;
import com.dxm.web.service.MassagesByUserIdServie;
import com.dxm.web.utils.ServletJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/massagesByUserId")
public class MassagesByUserIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        int userid = Integer.parseInt(req.getParameter("userid"));
        MassagesByUserIdServie massagesByUserIdServie = new MassagesByUserIdServie();
        try {
            List<Massages> massagesList= massagesByUserIdServie.UserIdMassages(userid);
            ServletJson.sendJson(resp,massagesList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
