package com.ongsat.video.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ParseController {

    @RequestMapping(value = "/parse/video", method = RequestMethod.POST)
    @ResponseBody
    public String parseVideo() {
        return "";
    }

}
