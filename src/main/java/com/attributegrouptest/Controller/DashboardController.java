package com.attributegrouptest.Controller;

import com.attributegrouptest.Domain.User;
import com.attributegrouptest.Service.blueprint.SecurityService;
import com.attributegrouptest.Service.blueprint.UserService;
import com.attributegrouptest.Utility.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Noobs on 04/09/2016.
 */
@Controller
@RequestMapping(value="/")
public class DashboardController {

    private UserService userService;
    private SecurityService securityService;
    private UserValidator validator;



    @Autowired
    public DashboardController(UserService userService, SecurityService securityService, UserValidator validator) {
        this.userService = userService;
        this.securityService = securityService;
        this.validator = validator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index()
    {

        return "redirect:/category";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute("user",new User());
        return "auth/register";
    }


    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "auth/register";
        }

        userService.save(user);

        return "redirect:/category";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(Model model,String error,String logout)
    {
        if(error != null)
        {
            model.addAttribute("error","Your username and password is invalid");
        }

        if(logout != null)
        {
            model.addAttribute("message","You have been logged out successfully");
        }

        return "auth/login";
    }


}
