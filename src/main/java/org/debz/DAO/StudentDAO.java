package org.debz.DAO;

import org.debz.model.Student;

import java.util.List;

/**
 * User: manu
 * Date: 11/12/13
 * Time: 12:58 PM
 */
public interface StudentDAO {

    public List<Student> getStudents(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countStudents();
    public Student getStudentByReg_no(final String reg_no);
    public Student saveStudent(Student student);

}
