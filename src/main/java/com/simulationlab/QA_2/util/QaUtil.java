package com.simulationlab.QA_2.util;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.utility.StringUtil;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Map;

public class QaUtil {
    private static final Logger logger = LoggerFactory.getLogger(QaUtil.class);

    public static int ANONYMOUS_ID = 2;
    public static int SYSTEM_ID = 3;

    public static String getJSONString(int code) {
        JSONObject j = new JSONObject();
        j.put("code", code);
        return j.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        JSONObject j = new JSONObject();
        j.put("code", code);
        j.put("msg", msg);
        return j.toJSONString();
    }

    public static String getJSONString(int code, Map<String, Object> msg) {
        JSONObject j = new JSONObject();
        j.put("code", code);
        for (Map.Entry<String, Object> entry : msg.entrySet()) {
            j.put(entry.getKey(), entry.getValue());
        }
        return j.toJSONString();
    }

    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error("生成MD5失败", e);
            return null;
        }
    }
}

