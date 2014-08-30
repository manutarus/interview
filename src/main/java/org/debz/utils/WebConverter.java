/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.debz.utils;

import org.debz.model.Agent;
import org.debz.model.Customer;
import org.debz.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class WebConverter {

    public static Map<String, Object> convertUser(final User user) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (user != null) {
            converted.put("f_name", user.getF_name());
            converted.put("o_name", user.getO_name());
            converted.put("level", user.getLevel());
        }
        return converted;
    }

    public static Map<String, Object> convertCustomer(final Customer customer) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (customer != null) {
            converted.put("sid", customer.getSid());
            converted.put("name", customer.getName());
            converted.put("phone_number", customer.getPhone_number());
            converted.put("id_number", customer.getId_number());
            converted.put("current_balance", customer.getCurrent_balance());
            converted.put("uuid", customer.getUuid());
        }
        return converted;
    }

    public static Map<String, Object> convertAgent(final Agent agent) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (agent != null) {
            converted.put("sid", agent.getSid());
            converted.put("company_name",agent.getCompany_name());
            converted.put("agent_number", agent.getAgent_number());
            converted.put("location", agent.getLocation());
            converted.put("uuid", agent.getUuid());
        }
        return converted;
    }

}