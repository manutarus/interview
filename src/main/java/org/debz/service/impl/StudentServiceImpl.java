package org.debz.service.impl;

import org.debz.DAO.StudentDAO;
import org.debz.model.Student;
import org.debz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: manu
 * Date: 11/12/13
 * Time: 2:09 PM
 */
public class StudentServiceImpl implements StudentService {



    @Autowired
    public StudentDAO studentDAO;

    public Student saveStudent(Student student){
        return studentDAO.saveStudent(student);
    }
    public List<Student> getStudents(final String search, final Integer pageNumber, final Integer pageSize) {
        return studentDAO.getStudents(search, pageNumber, pageSize);
    }

    public Number countStudents() {
        return studentDAO.countStudents();
    }
    public Student getStudentByReg_no(final String reg_no){
        return studentDAO.getStudentByReg_no(reg_no);
    }
}
