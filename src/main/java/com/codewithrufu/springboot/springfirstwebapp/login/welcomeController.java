package com.codewithrufu.springboot.springfirstwebapp.login;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class welcomeController {


//    private final AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    @RequestMapping(value = "/", method =  RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }





















//    @RequestMapping(value = "login", method =  RequestMethod.POST)
//    public String welcomePage(@RequestParam String name,
//                              @RequestParam String password,
//                              ModelMap model) {
//
//        if (authenticationService.authenticate(name, password)) {
//            model.put("name", name);
////            model.put("password", password);
//            return "welcome";
//        }
//        model.put("errorMessage", "Invalid Credentials");
//        return "login";
//    }
}
