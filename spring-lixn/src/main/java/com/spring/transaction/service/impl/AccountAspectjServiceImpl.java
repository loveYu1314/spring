package com.spring.transaction.service.impl;

import com.spring.transaction.dao.AccountMapper;
import com.spring.transaction.service.AccountAspectjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/12 9:31
 * @desc 说明
 */
@Service("iAccountAspectjService")
public class AccountAspectjServiceImpl implements AccountAspectjService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Map aspectjTransaction(String out, String in, BigDecimal money) {
        accountMapper.outAccount(out, money);
        if (money.intValue() > 40) {
            int i = money.intValue() / 0;
        }
        Map<String, String> map = new HashMap<>();
        accountMapper.inAccount(in, money);
        map.put("msg", "success");
        map.put("out", out);
        map.put("in", in);
        map.put("money", String.valueOf(money.doubleValue()));
        return map;
    }
}
