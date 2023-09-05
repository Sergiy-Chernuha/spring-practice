package ua.goit.springmvc.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public interface TestController {
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    ModelAndView testController();
}
