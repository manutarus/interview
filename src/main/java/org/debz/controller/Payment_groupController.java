package org.debz.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Payment_group;
import org.debz.service.Payment_groupService;
import org.debz.utils.WebConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * User: manu
 * Date: 11/19/13
 * Time: 11:17 PM
 */
@Controller
public class Payment_groupController {

    @Autowired
    private Payment_groupService payment_groupService;

    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/list/allGroups.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                             final @RequestParam(value = "pageNumber") Integer pageNumber,
                             final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (payment_groupService.countPayment_groups().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (Payment_group groupList : payment_groupService.getPayment_groups(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convertPayment_group(groupList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;
    }

    @RequestMapping(value = "/group.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSource(final @RequestParam(value = "uuid") String uuid) {

        return WebConverter.convertPayment_group(payment_groupService.getPayment_groupByUuid(uuid));
    }

    @RequestMapping(value = "/groupUpdateSave.json",method = RequestMethod.POST)
    public void voidSaveGroup(final @RequestBody Map<String, Object> map) {

        String uuid = (String) map.get("uuid");
        String name = (String) map.get("name");
        String rate_per_hour =  (String) map.get("rate_per_hour");
        String basic_pay = (String) map.get("basic_pay");

        if (StringUtils.isNotBlank(uuid)) {
        Payment_group payment_group = payment_groupService.getPayment_groupByUuid(uuid);

            if (StringUtils.isNotBlank(name) ) {
                payment_group.setRate_per_hour(rate_per_hour);
                payment_group.setBasic_pay(basic_pay);
                payment_group.setName(name);
                payment_groupService.savePayment_group(payment_group);
            }
            else {
                payment_group.setVoided(true);
                payment_groupService.savePayment_group(payment_group);
            }
        }
        else {
            Payment_group payment_group = new Payment_group();
            payment_group.setName(name);
            payment_group.setRate_per_hour(rate_per_hour);
            payment_group.setBasic_pay(basic_pay);
            payment_group.setUuid(UUID.randomUUID().toString());
            payment_groupService.savePayment_group(payment_group);
        }
    }
}
