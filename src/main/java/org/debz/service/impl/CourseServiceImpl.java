package org.debz.service.impl;

import org.debz.DAO.CourseDAO;
import org.debz.model.Course;
import org.debz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 11/10/13
 * Time: 8:26 AM
 */

@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    public CourseDAO courseDAO;


    public List<Course> getCourses(final String search, final Integer pageNumber, final Integer pageSize) {
        return courseDAO.getCourses(search, pageNumber, pageSize);
    }

    public Number countCourses() {
        return courseDAO.countCourses();
    }

}
