package org.debz.service;

import org.debz.model.Payment_group;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 11/19/13
 * Time: 9:05 PM
 */
@Transactional
public interface Payment_groupService {
    public Payment_group savePayment_group(Payment_group payment_group);
    public List<Payment_group> getPayment_groups(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countPayment_groups();
    public Payment_group getPayment_groupByUuid(final String uuid);
    public Payment_group getPayment_groupByName(String name);
}
