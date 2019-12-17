package org.launchcode.professionaltrainingtracker.controllers;

import org.launchcode.professionaltrainingtracker.models.Training;
import org.launchcode.professionaltrainingtracker.models.data.TrainingDao;
import org.launchcode.professionaltrainingtracker.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="training")
public class TrainingController {

    @Autowired
    private TrainingDao trainingDao;

    @Autowired
    private UserDao userDao;

    //Request path:  /training
    @RequestMapping(value="")
    public String findTraining(Model model){

        model.addAttribute("trainings", trainingDao.findAll());
        model.addAttribute("title", "My Dashboard");

        return "training/index";
    }

   /* //Request path:  training/list
    @RequestMapping(value="list")
    public String listTraining(Model model){

        model.addAttribute("trainings", trainingDao.findAll());
        model.addAttribute("title", "My Training List");

        return "training/list";
    }*/

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddTraining(Model model) {

        model.addAttribute("title", "Add Training");
        model.addAttribute(new Training());
        model.addAttribute("trainings", trainingDao.findAll());
        return "training/add";
    }

    /*@RequestMapping(value="add", method=RequestMethod.POST)
    public String displayAddTraining(@ModelAttribute @Valid Training newTraining, Errors errors, @RequestParam int Id, Model model)
    {*/

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String displayAddTraining(@ModelAttribute @Valid Training newTraining, Errors errors, Model model)  //removed @RequestParam int Id as throwing an error
    {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Training");
            return "training/add";
        }

       // User user = userDao.findOne(userId);
        //newTraining.setUser(user);
        trainingDao.save(newTraining);
        return "redirect:";


    }


}

