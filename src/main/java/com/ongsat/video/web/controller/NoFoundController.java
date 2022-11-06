package com.ongsat.video.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoFoundController implements ErrorController {

    @Override
    public String getErrorPath() {

        return "error";
    }

    @RequestMapping(value = "error",method = RequestMethod.GET)
    public String handleError(){
        return "404";
    }

}
