package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.User;
import org.debz.service.UserService;
import org.debz.utils.WebConverter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: tarus
 * Date: 9/18/13
 * Time: 12:32 PM
 */
@Controller

public class UsersController {

    @Autowired
    private UserService userService;


    private static final String LIST_VIEW = "userList";
    private static final String SUCCESS_VIEW = "redirect:/list/users.json";
    private final Log log = LogFactory.getLog(PersonListController.class);

    @RequestMapping(value = "users.json", method = RequestMethod.GET)
    public String printPersonList(ModelMap model) {

        List<User> persons = userService.getUsers();

        model.addAttribute("persons", persons);
        return LIST_VIEW;
    }
    @RequestMapping(value = "/list/allUsers.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                                    final @RequestParam(value = "pageNumber") Integer pageNumber,
                                    final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (userService.countUsers().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (User userList : userService.getUsers(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convert(userList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;

    }



    @RequestMapping(value = "/list/users2.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view()  {
        Map<String, Object> converted = new HashMap<String, Object>();
        Map<String, Object> response = new HashMap<String, Object>();
        JSONArray userArray = new JSONArray();
        List<Object> objects = new ArrayList<Object>();
        for (User user : userService.getUsers()) {
            //JSONObject userJSON = new JSONObject();
            converted.put("id", user.getSid());
            converted.put("names", user.getO_name());
            converted.put("level", user.getLevel());
            objects.add(converted);
        }
        //response.put("pages", 5);
        response.put("objects", objects);
        return response;
    }

        @RequestMapping(value = "/list/users.json", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (User user : userService.getUsers()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", user.getSid());
            userJSON.put("names", user.getO_name());
            userJSON.put("level", user.getLevel());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createperson.form")
    public String saveUser(
            @ModelAttribute("user") User user,BindingResult bindingResult) {

        userService.saveUser(user);

        return SUCCESS_VIEW;
    }


}