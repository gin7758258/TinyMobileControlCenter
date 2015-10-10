package me.antinomy.controller;

import me.antinomy.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ginvan on 15/9/9.
 */
@Controller
public class LoginController {

    @RequestMapping("/welcome.html")
    public ModelAndView doLogin(HttpServletRequest request) {
        return Util.createModelAndView("index", null, request);
    }
}
