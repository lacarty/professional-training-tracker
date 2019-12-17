package org.launchcode.professionaltrainingtracker.controllers;


import org.launchcode.professionaltrainingtracker.models.User;
import org.launchcode.professionaltrainingtracker.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    // User Login, already created an account
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    /*public void login(Model model, @ModelAttribute @Valid User user,
                      Errors errors, String verify) {*/

    public String login(Model model, @ModelAttribute @Valid User newUser,
                        Errors errors, String verify, HttpServletRequest request) {

        /*model.addAttribute(user);
        boolean passwordsMatch = true;
        if (user.getPassword() == null || verify == null
                || !user.getPassword().equals(verify)) {

            passwordsMatch = false;
            user.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }


        if (errors.hasErrors()) {
            model.addAttribute("title", "Invalid email or password");
            return "user/login";*/

        if (errors.hasErrors()) {
            model.addAttribute("title", "Login");
            return "user/login";

        }

        // If valid user, return to training/list for List of Trainings
        User userEntity = userDao.findByEmail(newUser.getEmail());
        model.addAttribute("title", "My Training");
        if (userEntity != null && userEntity.getEmail().equalsIgnoreCase(newUser.getEmail())) {

            //return "training";
            return "redirect:/training";
        }

        // if invalid user or wrong password redirect him to login page with invalid credentials prompt
        model.addAttribute("login", "Invalid Credentials ");
        newUser.setPassword("");
        return "user/login";
    }


    // Create an Account, add user
    @RequestMapping(value = "add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/add";
    }

    // Process form input data
    @RequestMapping(value = "add", method = RequestMethod.POST)
    private String add(Model model,
                       //@ModelAttribute @Valid
                       User newUser,
                       Errors errors, String verify) {

        model.addAttribute(newUser);
/*
            if (!errors.hasErrors()) {
                userDao.save(user);
                return "redirect: /training"; //use redirect when taking to different page
            }
            return "user/add";
*/
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            //return "user/add";
            return "redirect:/user/add";
        }


        userDao.save(newUser);
        //return "training";
        return "user/login";
    }



    @RequestMapping(value = "training", method = RequestMethod.GET)
    public String training(Model model) {

        model.addAttribute("title", "My Training");

        return "training";
    }

    /*@RequestMapping(value = "training", method = RequestMethod.POST)
    public String training(Model model) {
        model.addAttribute("title", "My Training");
    }*/


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";

    }
}



/*  Notes:
In UserDao, userDao.findbyId (since by email) for looking in database for email
have to have cookies to stayed logged in
example:
public interface UserDao extends CrudRepository<User,Integer> {
    User findByUsername(String username);*/
