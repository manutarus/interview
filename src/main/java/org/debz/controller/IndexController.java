package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.User;
import org.debz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class IndexController {
    @Autowired
    //private PersonService personService;
    private UserService userService;

    private static final String LIST_VIEW = "personlist";
    private static final String FORM_VIEW = "createperson";
    private static final String SUCCESS_VIEW = "redirect:person.list";

    private final Log log = LogFactory.getLog(this.getClass());



	@RequestMapping(method = RequestMethod.GET)

	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Survay system'");
		return "/WEB-INF/pages/view.jsp";
	}

    @RequestMapping(method = RequestMethod.GET, value = "user.form")
    public String userForm(
            @RequestParam(value = "userId", required = false) Integer userId,
            ModelMap modelMap) {

        User user    = null;

        if (userId != null)
            user = userService.getUser(userId);

        if (userId == null) {
            user = new User();
        }

        modelMap.put("user", user);

        return "user";
    }

    @RequestMapping(method = RequestMethod.POST, value = "user.form")
    public String saveUser(
            @ModelAttribute("user") User user,BindingResult bindingResult) {

        userService.saveUser(user);

        return "user";
    }


}