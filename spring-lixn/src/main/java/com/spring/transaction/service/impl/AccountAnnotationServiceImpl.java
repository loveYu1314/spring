package com.spring.transaction.service.impl;

import com.spring.transaction.dao.AccountMapper;
import com.spring.transaction.service.AccountAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/12 12:00
 * @desc 说明
 */
@Service("iAccountAnnotationService")
public class AccountAnnotationServiceImpl implements AccountAnnotationService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public Map annotationTransaction(String out, String in, BigDecimal money) {
        int outCount = accountMapper.outAccount(out, money);
        if (money.intValue() > 40) {
            int i = money.intValue() / 0;
        }
        Map<String, String> map = new HashMap<>();
        int inCount = accountMapper.inAccount(in, money);
        if (outCount == 0 || inCount == 0 || outCount > 1 || inCount > 1) {// 如果说更新了一条或者多条，那么就抛出异常
            map.put("msg", "更新了0条或者多条数据");
            throw new RuntimeException("更新了0条或者多条数据");
        }
        map.put("msg", "success");
        map.put("out", out);
        map.put("in", in);
        map.put("money", String.valueOf(money.doubleValue()));
        return map;
    }
}
