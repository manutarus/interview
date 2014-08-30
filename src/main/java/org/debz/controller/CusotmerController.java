package org.debz.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Customer;
import org.debz.service.CustomerService;
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
public class CusotmerController {

    @Autowired
    private CustomerService customerService;
//    sid, surname, other_names, gender, phone_number, id_number, date_created, creator, uuid, voided, voided_by, date_voided
    private final Log log = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "/customerUpdateSave.json",method = RequestMethod.POST)
    public void voidSaveGroup(final @RequestBody Map<String, Object> map) {
        String uuid = (String) map.get("uuid");
        String name = (String) map.get("name");
        String phone_number =  (String) map.get("phone_number");
        String id_number =  (String) map.get("id_number");
        String current_balance =  (String) map.get("current_balance");



        if (StringUtils.isNotBlank(uuid)) {
            Customer customer = customerService.getCustomerByUuid(uuid);
            if (StringUtils.isNotBlank(name)||StringUtils.isNotBlank(id_number)
                    ||StringUtils.isNotBlank(phone_number)||StringUtils.isNotBlank(phone_number) ) {
                customer.setUuid(uuid);
                customer.setName(name);
                customer.setId_number(id_number);
                customer.setPhone_number(phone_number);
                customer.setCurrent_balance(current_balance);
                customerService.saveCustomer(customer);
            }

        }
        else {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setId_number(id_number);
            customer.setPhone_number(phone_number);
            customer.setCurrent_balance(current_balance);
            customer.setUuid(UUID.randomUUID().toString());
            customerService.saveCustomer(customer);
        }
    }

    @RequestMapping(value = "/list/allCustomers.json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> view(final @RequestParam(value = "search") String search,
                             final @RequestParam(value = "pageNumber") Integer pageNumber,
                             final @RequestParam(value = "pageSize") Integer pageSize) {

        Map<String, Object> response = new HashMap<String, Object>();
        int pages = (customerService.countCustomers().intValue() + pageSize - 1)/ pageSize;
        List<Object> objects = new ArrayList<Object>();
        for (Customer customerList : customerService.getCustomers(search,pageNumber, pageSize)) {
            objects.add(WebConverter.convertCustomer(customerList));
        }
        response.put("pages", pages);
        response.put("objects", objects);
        return response;
    }

    @RequestMapping(value = "/customer.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMember(final @RequestParam(value = "uuid") String uuid) {

        return WebConverter.convertCustomer(customerService.getCustomerByUuid(uuid));
    }
    
    
}
