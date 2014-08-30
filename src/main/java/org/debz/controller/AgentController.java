package org.debz.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Agent;
import org.debz.service.AgentService;
import org.debz.utils.WebConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * User: manu
 * Date: 8/29/14
 * Time: 8:03 PM
 */
@Controller
public class AgentController {

    @Autowired
    private AgentService agentService;
    private final Log log = LogFactory.getLog(this.getClass());
    @RequestMapping(value = "/agentUpdateSave.json",method = RequestMethod.POST)
    public void voidSaveGroup(final @RequestBody Map<String, Object> map) {
        String uuid = (String) map.get("uuid");
        String agent_number = (String) map.get("agent_number");
        String company_name =  (String) map.get("company_name");
        String location =  (String) map.get("location");


        if (StringUtils.isNotBlank(uuid)) {
            Agent agent = agentService.getAgentByUuid(uuid);
            if (StringUtils.isNotBlank(agent_number)||StringUtils.isNotBlank(company_name)
                    ||StringUtils.isNotBlank(location)) {
                agent.setUuid(uuid);
                agent.setCompany_name(company_name);
                agent.setAgent_number(agent_number);
                agent.setLocation(location);
                agentService.saveAgent(agent);
            }

        }
        else {
            Agent agent = new Agent();
            agent.setCompany_name(company_name);
            agent.setAgent_number(agent_number);
            agent.setLocation(location);
            agent.setUuid(UUID.randomUUID().toString());
            agentService.saveAgent(agent);
        }
    }

    @RequestMapping(value = "/list/allAgents.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                             final @RequestParam(value = "pageNumber") Integer pageNumber,
                             final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (agentService.countAgents().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (Agent agentList : agentService.getAgents(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convertAgent(agentList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;
    }

    @RequestMapping(value = "/agent.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMember(final @RequestParam(value = "uuid") String uuid) {

        return WebConverter.convertAgent(agentService.getAgentByUuid(uuid));
    }
    
    
}
