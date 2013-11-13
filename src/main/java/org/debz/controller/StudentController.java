package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Course;
import org.debz.model.Student;
import org.debz.service.CourseService;
import org.debz.service.StudentService;
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
 * User: manu
 * Date: 11/12/13
 * Time: 1:31 PM
 */

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    private final Log log = LogFactory.getLog(PersonListController.class);


    @RequestMapping(value = "/list/allStudents.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                             final @RequestParam(value = "pageNumber") Integer pageNumber,
                             final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (studentService.countStudents().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (Student studentList : studentService.getStudents(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convertStudent(studentList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;

    }


}
