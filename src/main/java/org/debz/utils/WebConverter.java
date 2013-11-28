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

import org.debz.model.Payment_group;
import org.debz.model.User;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Write brief description about the class here.
 */
public class WebConverter {

    public static Map<String, Object> convertUser(final User user) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (user != null) {
            JSONArray list = new JSONArray();
            converted.put("f_name", user.getF_name());
            converted.put("o_name", user.getO_name());
            converted.put("level", user.getLevel());
        }
        return converted;
    }

    public static Map<String, Object> convertPayment_group(final Payment_group payment_group) {
        Map<String, Object> converted = new HashMap<String, Object>();
        if (payment_group != null) {
            converted.put("sid", payment_group.getSid());
            converted.put("name", payment_group.getName());
            converted.put("rate_per_hour", payment_group.getRate_per_hour());
            converted.put("basic_pay",payment_group.getBasic_pay());
            converted.put("uuid", payment_group.getUuid());

        }
        return converted;
    }

}