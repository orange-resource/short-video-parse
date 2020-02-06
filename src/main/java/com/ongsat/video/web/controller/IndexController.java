package com.ongsat.video.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = {"index", "", "home"}, method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
