package com.dxm.web.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ServletJson {

    public static  <T> void sendJson(HttpServletResponse response, List<T> result) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String json = JSON.toJSONString(result);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}

