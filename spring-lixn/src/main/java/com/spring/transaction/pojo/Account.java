package com.spring.transaction.pojo;

import java.math.BigDecimal;

public class Account {
    private Integer id;

    private String name;

    private BigDecimal money;

    public Account(Integer id, String name, BigDecimal money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Account() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}