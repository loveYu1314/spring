package com.spring.transaction.controller;

import com.spring.transaction.service.AccountProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
public class AccountProxyController {
    // 当使用代理处理业务时，那么 Controller 中就不能在使用 @Autowired 注入 Service 了
    // 为了测试 Aspectj 所以把这个注释掉了
//    @Resource(name = "serviceProxy")
    private AccountProxyService iAccountProxyService;

    @ResponseBody
    @RequestMapping(value = "proxy_trans.do", method = RequestMethod.POST)
    public Map proxyTransaction(String out, String in, Double money) {
        if (StringUtils.isEmpty(out) || StringUtils.isEmpty(in) || money == null) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", "Args are null");
            return map;
        }
        return iAccountProxyService.proxyTransaction(out, in, new BigDecimal(money.doubleValue()));
    }
}
