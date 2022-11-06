package com.ongsat.video.web.common.tool;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
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
        paramMap.put("url", url);
        paramMap.put("platform", platform);

        HttpResponse execute = HttpRequest
                .post("http://localhost:9905/parse/short/video")
                .form(paramMap)
                .execute();

        // System.out.println(execute.body());

        if (execute.isOk()) {
            String body = execute.body();

            JSONObject jsonObject = new JSONObject(body);
            Integer code = (Integer)jsonObject.get("code");
            if (code == 0) {
                String data = (String)jsonObject.get("data");
                // System.out.println(data);
                JSONObject dataJsonObject = new JSONObject(data);
                String title = (String)dataJsonObject.get("title");
                String playUrl = (String)dataJsonObject.get("playUrl");
                String imgUrl = (String)dataJsonObject.get("imgUrl");
                VideoParseDO videoParseDO = new VideoParseDO();
                videoParseDO.setVideoTitle(title);
                videoParseDO.setVideoUrl(playUrl);
                videoParseDO.setVideoImageUrl(imgUrl);
                return videoParseDO;
            }
        }

        return null;
    }

}
