package com.ongsat.video.web.controller;

import com.ongsat.video.web.service.VideoParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private VideoParseService videoParseService;

    @RequestMapping(value = {"index", "", "home"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView index = new ModelAndView("index");
        index.addObject("useCount", videoParseService.getUseTotal());
        return index;
    }

}
