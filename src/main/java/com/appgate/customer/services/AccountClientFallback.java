package com.appgate.customer.services;

import com.appgate.customer.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jgutierrez on 22/02/2019.
 */
@Component
public class AccountClientFallback implements AccountClient {

    @Override
    public List<Account> getAccounts(Integer customerId) {
        return new ArrayList<>();
    }
}
