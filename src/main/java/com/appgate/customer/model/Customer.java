package com.appgate.customer.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Jgutierrez on 21/02/2019.
 */
@Data
@Builder
public class Customer {

    private Integer id;
    private String name;
    private CustomerType type;
    private List<Account> accounts;

}
