package com.ongsat.video.web.controller;

import cn.hutool.core.util.StrUtil;
import com.ongsat.video.web.common.response.Response;
import com.ongsat.video.web.common.response.RspCode;
import com.ongsat.video.web.common.tool.IpUtil;
import com.ongsat.video.web.service.VideoParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api")
public class ParseController {

    @Autowired
    private VideoParseService videoParseService;

    @RequestMapping(value = "/parse/video", method = RequestMethod.POST)
    @ResponseBody
    public Response parseVideo(String url, HttpServletRequest httpServletRequest) {

        if (StrUtil.isBlank(url)) {
            return Response.build(RspCode.PARAMETER_ERROR);
        }

        String ip = IpUtil.getIp(httpServletRequest);

        return videoParseService.parseVideo(url, ip);
    }

}
