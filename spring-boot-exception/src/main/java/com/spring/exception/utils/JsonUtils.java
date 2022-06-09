package com.spring.exception.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtils {

    public static void writheJson(HttpServletResponse response, String data) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(data);
        out.flush();
        out.close();
    }
}
