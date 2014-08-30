package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.service.UserService;
import org.debz.utils.BCrypt;
import org.debz.utils.WebConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * User: manu
 * Date: 8/29/14
 * Time: 8:03 PM
 */

@Controller
@RequestMapping("/view")
@SessionAttributes("user")
public class ViewController {
    @Autowired
    private UserService userService;
    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(method = RequestMethod.POST)
    public String index(@RequestParam String username,String password,Model model) {
        if((!WebConverter.convertUser(userService.getUserByUsername(username)).isEmpty())
                && (BCrypt.checkpw(password, userService.getUserByUsername(username).getPassword())) ){
            log.info(username +" logged in successfully");
            return "view";
        }
        else{

            log.info(username + " failed login attempt");
            return "error";
        }
    }

}