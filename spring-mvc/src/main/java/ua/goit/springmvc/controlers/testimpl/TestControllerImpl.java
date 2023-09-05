package ua.goit.springmvc.controlers.testimpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.springmvc.controlers.TestController;

@Controller
public class TestControllerImpl implements TestController {

    @Override
    public ModelAndView testController() {
        return new ModelAndView("for-test");
    }
}
