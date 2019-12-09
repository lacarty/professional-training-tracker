package org.launchcode.professionaltrainingtracker.controllers;


import org.launchcode.professionaltrainingtracker.models.User;
import org.launchcode.professionaltrainingtracker.models.data.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

        @RequestMapping(value = "add", method = RequestMethod.GET)
        public String add(Model model) {
            model.addAttribute(new User());
            model.addAttribute("title", "Register");
            return "user/add";
        }

        @RequestMapping(value = "add", method = RequestMethod.POST)
        public String add(Model model, @ModelAttribute @Valid User user,
                          Errors errors) {

            model.addAttribute(user);

            if (!errors.hasErrors()) {
                return "training";
            }

            return "user/add";

        }

        @RequestMapping(value = "login", method = RequestMethod.GET)
        public String login(Model model) {
            model.addAttribute(new User());
            model.addAttribute("title", "Login");
            return "user/login";
        }

        @RequestMapping(value = "login", method = RequestMethod.POST)
        public String login(Model model, @ModelAttribute @Valid User user,
                            Errors errors, String verify) {

            model.addAttribute(user);
            boolean passwordsMatch = true;
            if (user.getPassword() == null || verify == null
                    || !user.getPassword().equals(verify)) {
                passwordsMatch = false;
                user.setPassword("");
                model.addAttribute("verifyError", "Passwords must match");
            }

            if (!errors.hasErrors() && passwordsMatch) {
                return "training/index";
            }

            return "user/login";
        }

    }
