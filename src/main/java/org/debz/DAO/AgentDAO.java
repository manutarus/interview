package org.debz.DAO;

import org.debz.model.Agent;

import java.util.List;

/**
 * User: manu
 * Date: 8/29/14
 * Time: 8:03 PM
 */
public interface AgentDAO {
    public Agent saveAgent(final Agent agent);
    public List<Agent> getAgents(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countAgents();
    public Agent getAgentByUuid(final String uuid);
    public Agent getAgentByCompanyName(String name);
}
