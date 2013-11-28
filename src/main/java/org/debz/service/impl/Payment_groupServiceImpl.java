package org.debz.service.impl;

import org.debz.DAO.Payment_groupDAO;
import org.debz.model.Payment_group;
import org.debz.service.Payment_groupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 11/19/13
 * Time: 9:06 PM
 */
public class Payment_groupServiceImpl implements Payment_groupService {
    @Autowired
    public Payment_groupDAO payment_groupDAO;

    public Payment_group savePayment_group(Payment_group payment_group){
        return payment_groupDAO.savePayment_group(payment_group);
    }
    public List<Payment_group> getPayment_groups(final String search, final Integer pageNumber, final Integer pageSize){
        return payment_groupDAO.getPayment_groups(search,pageNumber,pageSize);
    }
    public Number countPayment_groups(){
        return payment_groupDAO.countPayment_groups();
    }
    public Payment_group getPayment_groupByUuid(final String uuid){
        return payment_groupDAO.getPayment_groupByUuid(uuid);
    }
    public Payment_group getPayment_groupByName(String name){
        return payment_groupDAO.getPayment_groupByName(name);
    }
}
