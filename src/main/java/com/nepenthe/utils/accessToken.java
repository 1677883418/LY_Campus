package com.nepenthe.utils;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class accessToken {
    //授权类型,一般来说不用改
    private static final String grantType = "client_credential";
    //计时器
    private TimeInterval time;
    //token
    private String token;

    @Test
    public static String getToken(String appId, String secret) {
        String res = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret);
        System.out.println(res);
        return null;
    }
}
