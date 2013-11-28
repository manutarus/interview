package org.debz.DAO.hibernate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.Payment_groupDAO;
import org.debz.model.Payment_group;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: manu
 * Date: 11/19/13
 * Time: 5:48 PM
 */
@Repository
public class Payment_groupDAOImpl implements Payment_groupDAO {
    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Payment_group savePayment_group(final Payment_group payment_group){
        log.info("Group saved");
        sessionFactory.getCurrentSession().saveOrUpdate(payment_group);
        return payment_group;
    }

    public List<Payment_group> getPayment_groups(final String search, final Integer pageNumber, final Integer pageSize){
        Criteria criteria = getCurrentSession().createCriteria(Payment_group.class);
        if (StringUtils.isNotEmpty(search)) {
            Disjunction disjunction = Restrictions.disjunction();
            disjunction.add(Restrictions.ilike("name", search, MatchMode.ANYWHERE));
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
    public Number countPayment_groups(){
        Criteria criteria = getCurrentSession().createCriteria(Payment_group.class);
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
    public Payment_group getPayment_groupByUuid(final String uuid){
        Criteria criteria = getCurrentSession().createCriteria(Payment_group.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        return (Payment_group) criteria.uniqueResult();
    }
    public Payment_group getPayment_groupByName(String name){
        Criteria criteria = getCurrentSession().createCriteria(Payment_group.class);
        criteria.add(Restrictions.eq("name", name));
        return (Payment_group) criteria.uniqueResult();
    }


}
