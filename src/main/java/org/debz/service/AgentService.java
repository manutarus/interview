package org.debz.service;

import org.debz.model.Agent;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:03 PM
 */

@Transactional
public interface AgentService {

    public Agent saveAgent(final Agent agent);
    public List<Agent> getAgents(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countAgents();
    public Agent getAgentByUuid(final String uuid);
    public Agent getAgentByCompanyName(String name);
}
