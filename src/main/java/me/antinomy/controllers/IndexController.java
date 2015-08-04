package me.antinomy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DearGin on 15/8/5.
 */

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public ModelAndView indexPath() {
        return new ModelAndView("index");
    }
}
