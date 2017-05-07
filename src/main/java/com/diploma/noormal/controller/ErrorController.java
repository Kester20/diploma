package com.diploma.noormal.controller;

import com.diploma.noormal.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.diploma.noormal.util.Constants.ControllerConstants.ERROR_PAGE;
import static com.diploma.noormal.util.Constants.ControllerConstants.EXCEPTION;
import static com.diploma.noormal.util.Constants.ControllerConstants.URL;

/**
 * @author Arsalan. Created on 26.04.2017.
 */
@ControllerAdvice
public class ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleProductNotFoundError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(EXCEPTION, ex);
        mav.addObject(URL, req.getRequestURL());
        mav.setViewName(ERROR_PAGE);
        return mav;
    }
}
