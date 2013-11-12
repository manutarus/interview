package org.debz.DAO;

import org.debz.model.Course;

import java.util.List;

/**
 *
 * User: manu
 * Date: 11/10/13
 * Time: 7:56 AM
 *
 */
public interface CourseDAO {
    public List<Course> getCourses(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countCourses();

}
