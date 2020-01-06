package com.spring.transaction.controller;

import com.spring.transaction.service.AccountAnnotationService;
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
 * @date 2018/11/12 11:58
 * @desc 说明
 */
@Controller
public class AccountAnnotationController {
    @Autowired
    private AccountAnnotationService iAccountAnnotationService;
    @ResponseBody
    @RequestMapping(value = "annotation_trans.do", method = RequestMethod.POST)
    public Map proxyTransaction(String out, String in, Double money) {
        if (StringUtils.isEmpty(out) || StringUtils.isEmpty(in) || money == null) {
            Map<String, String> map = new HashMap<>();
            map.put("msg", "Args are null");
            return map;
        }
        return iAccountAnnotationService.annotationTransaction(out, in, new BigDecimal(money.doubleValue()));
    }
}
