package org.debz.DAO.hibernate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.DAO.AgentDAO;
import org.debz.model.Agent;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: manu
 * Date: 8/29/14
 * Time: 8:03 PM
 */
public class AgentDAOImpl implements AgentDAO {
    @Autowired
    SessionFactory sessionFactory;
    private Log log = LogFactory.getLog(this.getClass());

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Agent saveAgent(final Agent agent){
        log.info("Agent saved");
        sessionFactory.getCurrentSession().saveOrUpdate(agent);
        return agent;
    }
    public Agent getAgentByUuid(final String uuid){
        Criteria criteria = getCurrentSession().createCriteria(Agent.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        return (Agent) criteria.uniqueResult();
    }

    public List<Agent> getAgents(final String search, final Integer pageNumber, final Integer pageSize){
        Criteria criteria = getCurrentSession().createCriteria(Agent.class);
        if (StringUtils.isNotEmpty(search)) {
            Disjunction disjunction = Restrictions.disjunction();
            disjunction.add(Restrictions.ilike("location", search, MatchMode.ANYWHERE));
            disjunction.add(Restrictions.ilike("company_name", search, MatchMode.ANYWHERE));
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
    public Number countAgents(){
        Criteria criteria = getCurrentSession().createCriteria(Agent.class);
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
    public Agent getAgentByCompanyName(String name){
        Criteria criteria = getCurrentSession().createCriteria(Agent.class);
        criteria.add(Restrictions.eq("company_name", name));
        return (Agent) criteria.uniqueResult();
    }
}
