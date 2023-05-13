package com.dxm.web.servlet;

import com.dxm.web.entity.dto.AddMassageDto;
import com.dxm.web.service.AddMassageServie;
import com.dxm.web.utils.EntityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/addMassage")
public class AddMassageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        EntityUtil entityUtil = new EntityUtil();
        AddMassageDto addMassageDto = entityUtil.parseRequestToEntity(req, AddMassageDto.class);
        int userid=addMassageDto.getUserid();
        String title=addMassageDto.getTitle();
        String content=addMassageDto.getContent();
        String atcImg= addMassageDto.getAtcImg();
        PrintWriter out = resp.getWriter();
        AddMassageServie addMassageServie = new AddMassageServie();
        boolean tf=true;
        try {
            addMassageServie.insertMassage(userid,title,content,atcImg);
            out.print(tf);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
