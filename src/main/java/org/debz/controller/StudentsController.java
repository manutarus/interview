package org.debz.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Course;
import org.debz.model.Student;
import org.debz.service.CourseService;
import org.debz.service.StudentService;
import org.debz.utils.WebConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class StudentsController {

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


    @RequestMapping(value = "student.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSource(final @RequestParam(value = "reg_no") String reg_no) {
       // DataService dataService = Context.getService(DataService.class);
        Student student = studentService.getStudentByReg_no(reg_no);
        //DataSource dataSource = dataService.getDataSourceByUuid(uuid);
        return WebConverter.convertStudent(student);
    }

    @RequestMapping(value = "student34555.json", method = RequestMethod.POST)
    @ResponseBody
    public void saveStudent(final @RequestBody Map<String, Object> map) {
        //int sid = (Integer) map.get("sid");
        String surname = (String) map.get("surname");
        String other_names = (String) map.get("other_names");
        String reg_no = (String) map.get("reg_no");
//        int year = (Integer) map.get("year");
//        int suspended = (Integer) map.get("suspended");
        // if (sid < 0) {

        Student student = studentService.getStudentByReg_no(reg_no);
        student.setSurname(surname);
        student.setOther_names(other_names);
        student.setReg_no(reg_no);
        student.setYear(1);
        student.setSuspended(0);
        studentService.saveStudent(student);
    }



    @RequestMapping(value = "studentr.json", method = RequestMethod.POST)

    public void updateStudent3(final @RequestBody Map<String, Object> map) {
        //int sid = (Integer) map.get("sid");
        String surname = (String) map.get("surname");
        String other_names = (String) map.get("other_names");
        String reg_no = (String) map.get("reg_no");
//        int year = (Integer) map.get("year");
//        int suspended = (Integer) map.get("suspended");
       // if (sid < 0) {

            Student student = studentService.getStudentByReg_no(reg_no);
            student.setSurname(surname);
            student.setOther_names(other_names);
            student.setReg_no(reg_no);
            student.setYear(1);
            student.setSuspended(0);
            studentService.saveStudent(student);

//        } else {
//            Student student = new Student();
//            student.setSurname(surname);
//            student.setOther_names(other_names);
//            student.setReg_no(reg_no);
//           // student.setYear(y);
//            student.setSuspended(0);
//            studentService.saveStudent(student);
//        }
    }


}
