package com.dxm.web.servlet;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/everyDayWord")
public class EveryDayWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD, DELETE, PUT");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        String s = HttpUtil.get("http://open.iciba.com/dsapi/");
        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = JSONObject.parseObject(s);
        Object note = jsonObject.get("note");
        Object date = jsonObject.get("dateline");
        Map<String,String> data = new HashMap<>(8);
        data.put("content", note.toString());
        data.put("date", date.toString());
        out.print(JSONObject.toJSON(data));
        out.flush();
    }
}
