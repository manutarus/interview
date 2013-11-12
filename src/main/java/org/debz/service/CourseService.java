package org.debz.service;

import org.debz.model.Course;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: manu
 * Date: 11/10/13
 * Time: 7:52 AM
 * To change this template use File | Settings | File Templates.
 */

@Transactional
public interface CourseService {

    public List<Course> getCourses(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countCourses();
}
