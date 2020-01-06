package com.spring.transaction.service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/12 11:59
 * @desc 说明
 */
public interface AccountAnnotationService {
    Map annotationTransaction(String out, String in, BigDecimal money);
}
