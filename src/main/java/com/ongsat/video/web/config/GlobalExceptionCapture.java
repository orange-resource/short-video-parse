package com.ongsat.video.web.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionCapture {

    public static final String DEFAULT_404_ERROR_VIEW = "404";
    public static final String DEFAULT_500_ERROR_VIEW = "404";

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException exception) {
        ModelAndView modelAndView = new ModelAndView(DEFAULT_500_ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView(DEFAULT_500_ERROR_VIEW);
        return modelAndView;
    }


    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView default404ErrorHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView(DEFAULT_404_ERROR_VIEW);
        return modelAndView;
    }

}
