package org.debz.DAO.hibernate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.CustomerDAO;
import org.debz.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: manu
 * Date: 8/29/14
 * Time: 8:18 PM
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Customer saveCustomer(final Customer agent){
        log.info("Customer saved");
        sessionFactory.getCurrentSession().saveOrUpdate(agent);
        return agent;
    }
    public Customer getCustomerByUuid(final String uuid){
        Criteria criteria = getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        return (Customer) criteria.uniqueResult();
    }

    public List<Customer> getCustomers(final String search, final Integer pageNumber, final Integer pageSize){
        Criteria criteria = getCurrentSession().createCriteria(Customer.class);
        if (StringUtils.isNotEmpty(search)) {
            Disjunction disjunction = Restrictions.disjunction();
            disjunction.add(Restrictions.ilike("name", search, MatchMode.ANYWHERE));
            disjunction.add(Restrictions.ilike("phone_number", search, MatchMode.ANYWHERE));
            criteria.add(disjunction);
        }
        if (pageNumber != null) {
            criteria.setFirstResult((pageNumber - 1) * pageSize);
        }
        if (pageSize != null) {
            criteria.setMaxResults(pageSize);
        }
        criteria.addOrder(Order.desc("sid"));
        return criteria.list();
    }
    public Number countCustomers(){
        Criteria criteria = getCurrentSession().createCriteria(Customer.class);
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
    public Customer getCustomerByName(String name){
        Criteria criteria = getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("name", name));
        return (Customer) criteria.uniqueResult();
    }


}
