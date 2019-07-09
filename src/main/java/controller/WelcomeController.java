package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.FileStorageService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/welcome")
    public class WelcomeController {
    @Autowired
    private FileStorageService fileStorageService;

        private static final Logger logger = Logger.getLogger(WelcomeController.class);

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView getWelcome() {

            //logs debug message
            if(logger.isDebugEnabled()){
                logger.debug("getWelcome is executed!");
            }

            //logs exception
            logger.error("This is Error message", new Exception("Testing"));

            ModelAndView model = new ModelAndView("welcome");
            model.addObject("msg", "Hello Spring MVC + Log4j");
            return model;

        }

    @GetMapping(path = "/homepage")
    public ModelAndView findAll() {


        ModelAndView modelAndView = new ModelAndView("homepage");



        return modelAndView;
    }
    @GetMapping(path = "/aboutPage")
    public ModelAndView aboutPage() {


        ModelAndView modelAndView = new ModelAndView("aboutPage");



        return modelAndView;
    }


    }

