package org.debz.DAO.hibernate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.MemberDAO;
import org.debz.model.Member;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 1:59 PM
 */
@Repository
public class MemberDaoImpl implements MemberDAO{
    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Member saveMember(final Member member){
        log.info("Member saved");
        sessionFactory.getCurrentSession().saveOrUpdate(member);
        return member;
    }
    public Member getMemberByUuid(final String uuid){
        Criteria criteria = getCurrentSession().createCriteria(Member.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        return (Member) criteria.uniqueResult();
    }

    public List<Member> getMembers(final String search, final Integer pageNumber, final Integer pageSize){
        Criteria criteria = getCurrentSession().createCriteria(Member.class);
        if (StringUtils.isNotEmpty(search)) {
            Disjunction disjunction = Restrictions.disjunction();
            disjunction.add(Restrictions.ilike("surname", search, MatchMode.ANYWHERE));
            disjunction.add(Restrictions.ilike("other_names", search, MatchMode.ANYWHERE));
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
    public Number countMembers(){
        Criteria criteria = getCurrentSession().createCriteria(Member.class);
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
    public Member getMemberByName(String name){
        Criteria criteria = getCurrentSession().createCriteria(Member.class);
        criteria.add(Restrictions.eq("surname", name));
        return (Member) criteria.uniqueResult();
    }
}
