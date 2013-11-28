package org.debz.DAO;

import org.debz.model.Payment_group;

import java.util.List;

/**
 * User: manu
 * Date: 11/19/13
 * Time: 5:43 PM
 */
public interface Payment_groupDAO {
    public Payment_group savePayment_group(final Payment_group payment_group);
    public List<Payment_group> getPayment_groups(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countPayment_groups();
    public Payment_group getPayment_groupByUuid(final String uuid);
    public Payment_group getPayment_groupByName(String name);
}
