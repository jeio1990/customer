package com.appgate.customer.services;

import com.appgate.customer.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Jgutierrez on 21/02/2019.
 */
@FeignClient(name = "account-service", value = "account-service", fallback = AccountClientFallback.class)
public interface AccountClient {

    @GetMapping(value = "/accounts/customer/{customerId}")
    List<Account> getAccounts(@PathVariable("customerId") Integer customerId);

}
