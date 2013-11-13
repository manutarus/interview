package org.debz.DAO.hibernate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.StudentDAO;
import org.debz.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: manu
 * Date: 11/12/13
 * Time: 1:09 PM
 */

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public Student getStudentByReg_no(final String reg_no){
        Criteria criteria = getCurrentSession().createCriteria(Student.class);
        criteria.add(Restrictions.eq("reg_no", reg_no));
        criteria.add(Restrictions.eq("suspended",0));
        return (Student) criteria.uniqueResult();
    }

    public List<Student> getStudents(final String search, final Integer pageNumber, final Integer pageSize) {
        // log.info("Trying to get  number of persons ");
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
//       // log.info("Got this number of persons "+ criteria.list().size());
//       // criteria.addOrder(Order.asc("sid"));
//        return criteria.list();
//        return sessionFactory.getCurrentSession().createQuery("from Student").list();

        Criteria criteria = getCurrentSession().createCriteria(Student.class);
        if (StringUtils.isNotEmpty(search)) {
            Disjunction disjunction = Restrictions.disjunction();
            disjunction.add(Restrictions.ilike("surname", search, MatchMode.ANYWHERE));
            disjunction.add(Restrictions.ilike("reg_no", search, MatchMode.ANYWHERE));
            criteria.add(disjunction);
        }
//        criteria.add(Restrictions.eq("retired", Boolean.FALSE));
        if (pageNumber != null) {
            criteria.setFirstResult((pageNumber - 1) * pageSize);
        }
        if (pageSize != null) {
            criteria.setMaxResults(pageSize);
        }
        criteria.addOrder(Order.desc("sid"));
        return criteria.list();
    }

    @Override
    public Number countStudents() {
        Criteria criteria = getCurrentSession().createCriteria(Student.class);
//        criteria.add(Restrictions.eq("retired", Boolean.FALSE));
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
}


