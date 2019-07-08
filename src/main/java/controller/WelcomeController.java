package controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/welcome")
    public class WelcomeController {

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

    @GetMapping(path = "/welcomePage")
    public ModelAndView findAll() {


        ModelAndView modelAndView = new ModelAndView("welcomePage");



        return modelAndView;
    }


    }

