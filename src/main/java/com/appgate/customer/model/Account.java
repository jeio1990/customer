package com.appgate.customer.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Jgutierrez on 21/02/2019.
 */
@Data
public class Account {

    private Integer id;
    private String number;

    public Account() {
    }

    public Account(Integer id, String number) {
        this.id = id;
        this.number = number;
    }
}
