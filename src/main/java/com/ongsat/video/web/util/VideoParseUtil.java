package com.ongsat.video.web.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.ongsat.video.web.entity.dataobject.VideoParseDO;

import java.util.HashMap;
import java.util.Map;

public class VideoParseUtil {

    public static final String DY = "抖音";
    public static final String WS = "微视";
    public static final String KS = "快手";
    public static final String XKS = "小咖秀";
    public static final String MIAO_PAI = "秒拍";

    public static VideoParseDO parse(String url, String platform) {

        Map<String, Object> paramMap = new HashMap<>();

        HttpResponse execute = HttpRequest
                .post("http://localhost:9905/video/short/parse")
                .form(paramMap)
                .execute();

        System.out.println(execute.body());

        return null;
    }

}
