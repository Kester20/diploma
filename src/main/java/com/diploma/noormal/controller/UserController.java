package com.diploma.noormal.controller;


import com.diploma.noormal.model.User;
import com.diploma.noormal.service.OrderService;
import com.diploma.noormal.service.SecurityService;
import com.diploma.noormal.service.UserService;
import com.diploma.noormal.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    private OrderService orderService;

    @Autowired
    public UserController(UserService userService, SecurityService securityService,
                          UserValidator userValidator, OrderService orderService) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute(USER_FORM, new User());
        return "registered";
    }

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public String registration(@ModelAttribute(USER_FORM) User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registered";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute(ERROR, INVALID_TOKENS);
        }
        return "login";
    }

    @RequestMapping(value = "/personal")
    public String personal(){
        return "personal";
    }

    @RequestMapping(value = "/info")
    public ModelAndView info(@RequestParam(value = "info") String info){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUsername(name);

        ModelAndView modelAndView = new ModelAndView();
        prepareView(info, user, modelAndView);
        return modelAndView;
    }

    private void prepareView(String info, User user,  ModelAndView modelAndView){
        switch (info){
            case "personalInfo":{
                modelAndView.addObject("userName", user.getUsername());
                modelAndView.addObject("userEmail", user.getEmail());
                modelAndView.setViewName("/personalInfo");
                break;
            }

            case "wishList":{

                break;
            }

            case "orderList":{
                modelAndView.addObject("orderList", orderService.findOrdersByUser(user.getId()));
                modelAndView.setViewName("/personalOrderList");
                break;
            }

            case "commentList":{

                break;
            }
        }
    }
}
