package com.ongsat.video.web.util;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {

    public static String getIp(HttpServletRequest request){
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StrUtil.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            int index=XFor.indexOf(",");
            if(index!=-1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor=Xip;
        if(StrUtil.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if(StrUtil.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)){
            XFor=request.getHeader("Proxy-Client-IP");
        }
        if(StrUtil.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)){
            XFor=request.getHeader("WL-Proxy-Client-IP");
        }
        if(StrUtil.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)){
            XFor=request.getHeader("HTTP_CLIENT_IP");
        }
        if(StrUtil.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)){
            XFor=request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(StrUtil.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)){
            XFor=request.getRemoteAddr();
        }
        return XFor;
    }

}
