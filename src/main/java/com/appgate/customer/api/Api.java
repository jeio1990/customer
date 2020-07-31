package com.appgate.customer.api;

import com.appgate.customer.model.Account;
import com.appgate.customer.model.Customer;
import com.appgate.customer.model.CustomerType;
import com.appgate.customer.services.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Jgutierrez on 22/02/2019.
 */
@RestController
public class Api {

    protected Logger logger = Logger.getLogger(Api.class.getName());

    @Autowired
    private AccountClient accountClient;

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(Customer.builder().id(1).name("Coca Cola").type(CustomerType.COMPANY).build());
        customers.add(Customer.builder().id(2).name("Juan David").type(CustomerType.INDIVIDUAL).build());
        customers.add(Customer.builder().id(3).name("Bavaria").type(CustomerType.COMPANY).build());
    }

    @RequestMapping("/customers/name/{name}")
    public Customer findByName(@PathVariable("name") String name) {
        logger.info(String.format("Customer.findByName(%s)", name));
        return customers.stream().filter(it -> it.getName().equals(name)).findFirst().get();
    }

    @RequestMapping("/customers")
    public List<Customer> findAll() {
        logger.info("Customer.findAll()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @RequestMapping("/customers/{id}")
    public Customer findById(@PathVariable("id") Integer id) {
        logger.info(String.format("Customer.findById(%s)", id));
        Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
        List<Account> accounts =  accountClient.getAccounts(id);
        customer.setAccounts(accounts);
        return customer;
    }

}
