package org.debz.DAO;

import org.debz.model.Customer;

import java.util.List;

/**
 * User: manu
 * Date: 8/29/14
 * Time: 8:14 PM
 */
public interface CustomerDAO {
    public Customer saveCustomer(final Customer customer);
    public List<Customer> getCustomers(final String search, final Integer pageNumber, final Integer pageSize);
    public Number countCustomers();
    public Customer getCustomerByUuid(final String uuid);
    public Customer getCustomerByName(String name);
}
