package org.debz.DAO.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.CourseDAO;
import org.debz.model.Course;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: manu
 * Date: 11/10/13
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CourseDAOImpl implements CourseDAO {


    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public List<Course> getCourses(final String search, final Integer pageNumber, final Integer pageSize) {
        // log.info("Trying to get  number of persons ");
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
//       // log.info("Got this number of persons "+ criteria.list().size());
//       // criteria.addOrder(Order.asc("sid"));
//        return criteria.list();
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }

    @Override
    public Number countCourses() {
        Criteria criteria = getCurrentSession().createCriteria(Course.class);
//        criteria.add(Restrictions.eq("retired", Boolean.FALSE));
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
}
