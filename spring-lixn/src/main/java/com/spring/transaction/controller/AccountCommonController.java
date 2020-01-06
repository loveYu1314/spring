package com.spring.transaction.controller;

import com.spring.transaction.service.AccountCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/10 15:17
 * @desc 基于编码方式的事务管理，不推荐
 */
@Controller
@RequestMapping("/")
public class AccountCommonController {
    @Autowired
    private AccountCommonService iAccountCommonService;

    // 这一种是没有事务的情形
    @ResponseBody
    @RequestMapping(value = "common.do", method = RequestMethod.POST)
    public Map common(String out, String in, Double money) {
        if (StringUtils.isEmpty(out) || StringUtils.isEmpty(in) || money == null) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", "Args are null");
            return map;
        }
        return iAccountCommonService.accountCommon(out, in, new BigDecimal(money.doubleValue()));
    }
    // 这一种是有手动事务的情形，但是并不能保证在不出一异常时的回滚
    @ResponseBody
    @RequestMapping(value = "common_trans.do", method = RequestMethod.POST)
    public Map commonTransaction(String out, String in, Double money) {
        if (StringUtils.isEmpty(out) || StringUtils.isEmpty(in) || money == null) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", "Args are null");
            return map;
        }
        return iAccountCommonService.commonTransaction(out, in, new BigDecimal(money.doubleValue()));
    }

    // 这一种是有手动事务的情形，解决了如果其中一个人不存在的情形出现的bug
    @ResponseBody
    @RequestMapping(value = "common_trans_deal_zero.do", method = RequestMethod.POST)
    public Map commonTransactionDealZero(String out, String in, Double money) {
        if (StringUtils.isEmpty(out) || StringUtils.isEmpty(in) || money == null) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", "Args are null");
            return map;
        }
        return iAccountCommonService.commonTransactionDealZero(out, in, new BigDecimal(money.doubleValue()));
    }
}
