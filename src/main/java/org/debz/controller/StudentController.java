package org.debz.controller;

/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Student;
import org.debz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
@Controller
@RequestMapping(value = "student.json")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final Log log = LogFactory.getLog(PersonListController.class);

//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> getSource(final @RequestParam(value = "uuid") String uuid) {
//        DataService dataService = Context.getService(DataService.class);
//        DataSource dataSource = dataService.getDataSourceByUuid(uuid);
//        return WebConverter.convertDataSource(dataSource);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveStudent(final @RequestBody Map<String, Object> map) {

        String surname = (String) map.get("surname");
//        String other_names = (String) map.get("other_names");
//        String reg_no = (String) map.get("reg_no");
        //DataService dataService = Context.getService(DataService.class);
//        Student student = studentService.getStudentByReg_no("05B0047");
        Student student = new Student();
        student.setSid(1);
        student.setSurname(surname);
        student.setOther_names("Lazy");
        student.setReg_no("05B0047");
        student.setYear(1);
        student.setSuspended(0);
        studentService.saveStudent(student);
    }
}
