package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.User;
import org.debz.service.UserService;
import org.debz.utils.BCrypt;
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

public class Temp {
    public static void main(String[] args) {
        System.out.println((BCrypt.hashpw("12345", BCrypt.gensalt(12))));
    }
}
