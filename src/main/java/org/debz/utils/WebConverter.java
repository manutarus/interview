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
package org.debz.utils;

import org.debz.model.Course;
import org.debz.model.Student;
import org.debz.model.User;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class WebConverter {

    public static Map<String, Object> convert(final User user) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (user != null) {
            JSONArray list = new JSONArray();
            converted.put("f_name", user.getF_name());
            converted.put("o_name", user.getO_name());
            converted.put("level", user.getLevel());
        }
        return converted;
    }

    public static Map<String, Object> convertCourse(final Course course) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (course != null) {
            converted.put("sid", course.getSid());
            converted.put("name", course.getName());
            converted.put("units", course.getUnits());
            converted.put("units_percentage", course.getUnits_percentage());
        }
        return converted;
    }

    public static Map<String, Object> convertStudent(final Student student) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (student != null) {
            converted.put("sid", student.getSid());
            converted.put("surname", student.getSurname());
            converted.put("other_names", student.getOther_names());
            converted.put("reg_no", student.getReg_no());
            converted.put("year", student.getYear());
            if(student.getSuspended()==1){
                converted.put("suspended","Yes");
            }
            else{
                converted.put("suspended","No");
            }
        }
        return converted;
    }

}