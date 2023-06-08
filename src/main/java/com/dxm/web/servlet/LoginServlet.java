package com.dxm.web.servlet;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.dxm.web.service.UserService;
import com.dxm.web.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        try {
            Map<String, String> login = userService.login(username, password);
            Object o = JSONObject.toJSON(login);
            out.print(o);
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        out.flush();
        out.close();
    }
}
