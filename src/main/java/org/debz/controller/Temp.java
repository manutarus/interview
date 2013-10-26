package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.User;
import org.debz.service.UserService;
import org.debz.utils.WebConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: tarus
 * Date: 9/13/13
 * Time: 10:52 AM
 */
@Controller
@RequestMapping(value = "/list/test.json")
public class Temp {

    @Autowired
    private UserService userService;

    private final Log log = LogFactory.getLog(getClass());

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> view(final @RequestParam(value = "search") String search,
                                    final @RequestParam(value = "pageNumber") Integer pageNumber,
                                    final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
       // PreferredFormService preferredFormService = Context.getService(PreferredFormService.class);
        int pages = (5 + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (User userList : userService.getUsers(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convert(userList));
        }

        response.put("pages", pages);
        response.put("objects", objects);
        return response;

    }
}
