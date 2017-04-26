package com.diploma.noormal.controller;


import com.diploma.noormal.model.User;
import com.diploma.noormal.service.SecurityService;
import com.diploma.noormal.service.UserService;
import com.diploma.noormal.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.diploma.noormal.util.Constants.ControllerConstants.ERROR;
import static com.diploma.noormal.util.Constants.ControllerConstants.INVALID_TOKENS;
import static com.diploma.noormal.util.Constants.ControllerConstants.USER_FORM;

/**
 * @author Arsalan. Created on 17.04.2017.
 */
@Controller
public class UserController {

    private UserService userService;
    private SecurityService securityService;
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute(USER_FORM, new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute(USER_FORM) User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/index";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute(ERROR, INVALID_TOKENS);
        }
        return "account";
    }
}
