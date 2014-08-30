package org.debz.service.impl;

import org.debz.DAO.AgentDAO;
import org.debz.model.Agent;
import org.debz.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:07 PM
 */
public class AgentServiceImpl implements AgentService {
    @Autowired
    public AgentDAO agentDAO;

    public Agent saveAgent(Agent agent){
        return agentDAO.saveAgent(agent);
    }
    public Agent getAgentByUuid(final String uuid){
        return agentDAO.getAgentByUuid(uuid);
    }
    public List<Agent> getAgents(final String search, final Integer pageNumber, final Integer pageSize){
        return agentDAO.getAgents(search,pageNumber,pageSize);
    }
    public Number countAgents(){
        return agentDAO.countAgents();
    }
    public Agent getAgentByCompanyName(String name){
        return agentDAO.getAgentByCompanyName(name);
    }
}
