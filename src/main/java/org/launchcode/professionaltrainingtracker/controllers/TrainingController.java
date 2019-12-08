package org.launchcode.professionaltrainingtracker.controllers;

import org.launchcode.professionaltrainingtracker.models.Training;
import org.launchcode.professionaltrainingtracker.models.data.TrainingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="training")
public class TrainingController {

    @Autowired
    TrainingDao trainingDao;

    @RequestMapping(value="")
    public String findTraining(Model model){

        model.addAttribute("trainings", trainingDao.findAll());
        model.addAttribute("title", "Training");

        return "training/index";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddTraining(Model model) {

        model.addAttribute("title", "Add Training");
        model.addAttribute(new Training());
        model.addAttribute("trainings", trainingDao.findAll());
        return "training/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String displayAddTraining(@ModelAttribute @Valid Training newTraining, Errors errors, @RequestParam int Id, Model model)
    {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Training");

            return "training/add";
        }

        trainingDao.save(newTraining);
        return "training/add";
    }


}

