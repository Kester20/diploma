package com.diploma.noormal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

import static com.diploma.noormal.util.Constants.ControllerConstants.LOCALE;

/**
 * @author Arsalan. Created on 16.05.2017.
 */
@Controller
public class LocaleController {

    @RequestMapping(value = "/locale")
    @ResponseBody
    public void changeLocale(@RequestParam(name = "locale") String locale, HttpServletRequest request){
        Locale result = new Locale(locale);
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE, result);
    }

}
