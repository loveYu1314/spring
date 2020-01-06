package com.spring.transaction.service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/10 15:05
 * @desc 说明
 */
public interface AccountCommonService {
    Map accountCommon(String outAccount, String inAccount, BigDecimal money);

    Map commonTransaction(String outAccount, String inAccount, BigDecimal money);

    Map commonTransactionDealZero(String outAccount, String inAccount, BigDecimal money);
}
