package org.debz.service.impl;

import org.debz.DAO.CustomerDAO;
import org.debz.model.Customer;
import org.debz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: manu
 * Date: 12/30/13
 * Time: 2:07 PM
 */
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerDAO customerDAO;

    public Customer saveCustomer(Customer customer){
        return customerDAO.saveCustomer(customer);
    }
    public Customer getCustomerByUuid(final String uuid){
        return customerDAO.getCustomerByUuid(uuid);
    }
    public List<Customer> getCustomers(final String search, final Integer pageNumber, final Integer pageSize){
        return customerDAO.getCustomers(search,pageNumber,pageSize);
    }
    public Number countCustomers(){
        return customerDAO.countCustomers();
    }
    public Customer getCustomerByName(String name){
        return customerDAO.getCustomerByName(name);
    }
}
