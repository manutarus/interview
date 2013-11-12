package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Course;
import org.debz.service.CourseService;
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
 * User: manu
 * Date: 11/10/13
 * Time: 8:48 AM
 */
@Controller
public class CoursesController {
    @Autowired
    private CourseService courseService;

    private final Log log = LogFactory.getLog(PersonListController.class);


    @RequestMapping(value = "/list/allCourses.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                             final @RequestParam(value = "pageNumber") Integer pageNumber,
                             final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (courseService.countCourses().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (Course courseList : courseService.getCourses(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convertCourse(courseList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;

    }






}