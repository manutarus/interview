package org.debz.service;

import org.debz.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:03 PM
 */

@Transactional
public interface CustomerService {
    public Customer saveCustomer(final Customer customer);
    public List<Customer> getCustomers(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countCustomers();
    public Customer getCustomerByUuid(final String uuid);
    public Customer getCustomerByName(String name);

}
