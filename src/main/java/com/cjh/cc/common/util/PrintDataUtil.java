package com.cjh.cc.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 输出参数
 */
public class PrintDataUtil {
    /**
     * 输入数据
     * @param response response对象
     * @param contentType 内容类型
     * @param encode 编码
     * @param data 数据
     */
    public static void printData(HttpServletResponse response, String contentType, String encode, Object data) {
        response.setCharacterEncoding(encode);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType(contentType);
        PrintWriter writer = null;
        try {
            writer=response.getWriter();
            writer.print(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

    }


    /**
     * 输入数据
     * @param response
     * @param data
     */
    public static void printData(HttpServletResponse response, String contentType, Object data) {
        PrintDataUtil.printData(response, contentType, "utf-8", data);
    }

    /**
     * 输入数据
     * @param response
     * @param data
     */
    public static void printData(HttpServletResponse response, Object data) {
        PrintDataUtil.printData(response, "application/json", "utf-8", data);
    }
}
