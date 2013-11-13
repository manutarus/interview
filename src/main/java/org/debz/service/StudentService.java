package org.debz.service;

import org.debz.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 11/12/13
 * Time: 2:07 PM
 */

@Transactional
public interface StudentService {
    public List<Student> getStudents(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countStudents();

}
