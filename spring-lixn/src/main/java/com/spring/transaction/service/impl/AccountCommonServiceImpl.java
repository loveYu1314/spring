package com.spring.transaction.service.impl;

import com.spring.transaction.dao.AccountMapper;
import com.spring.transaction.service.AccountCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/10 15:06
 * @desc 说明
 */
@Service("iAccountCommonService")
public class AccountCommonServiceImpl implements AccountCommonService {
    @Autowired
    private AccountMapper iAccountDao;
    //    @Autowired // 由于Proxy 中没有此事务模板，所以再测试时不能这样使用了，先注释掉
    private TransactionTemplate transactionTemplate;

    @Override
    public Map accountCommon(String outAccount, String inAccount, BigDecimal money) {
        iAccountDao.outAccount(outAccount, money);
        if (money.intValue() > 40) {// 为了方便一次测试两种情形而加的判断
            int i = money.intValue() / 0;
        }
        iAccountDao.inAccount(inAccount, money);
        Map<String, String> map = new HashMap<>();
        map.put("msg", "success");
        map.put("out", outAccount);
        map.put("in", inAccount);
        map.put("money", String.valueOf(money.doubleValue()));
        return map;
    }

    @Override
    public Map commonTransaction(String outAccount, String inAccount, BigDecimal money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // 这种虽然能保证在事务执行的时候如果出现异常，
                // 那么就会回滚，但是如果没出现异常，
                // 那么就会其中一个增加或减少，而另外一个不变，这明显也是一种bug，下面就提供一种解决方法
                iAccountDao.outAccount(outAccount, money);
                if (money.intValue() > 40) {
                    int i = money.intValue() / 0;
                }
                iAccountDao.inAccount(inAccount, money);
            }
        });
        Map<String, String> map = new HashMap<>();
        map.put("msg", "success");
        map.put("out", outAccount);
        map.put("in", inAccount);
        map.put("money", String.valueOf(money.doubleValue()));
        return map;
    }

    @Override
    public Map commonTransactionDealZero(String outAccount, String inAccount, BigDecimal money) {
        Map<String, String> map = new HashMap<>();
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // 这种虽然能保证在事务执行的时候如果出现异常，
                // 那么就会回滚，但是如果没出现异常，
                // 那么就会其中一个增加或减少，而另外一个不变，这明显也是一种bug，所以就判断如果两个返回值都其中一个小于等于0时，就抛出异常
                int outCount = iAccountDao.outAccount(outAccount, money);
                if (money.intValue() > 40) {
                    int i = money.intValue() / 0;
                }
                int inCount = iAccountDao.inAccount(inAccount, money);
                if (outCount == 0 || inCount == 0 || outCount > 1 || inCount > 1) {// 如果说更新了一条或者多条，那么就抛出异常
                    map.put("msg", "更新了0条或者多条数据");
                    throw new RuntimeException("更新了0条或者多条数据");
                }
            }
        });
        map.put("msg", "success");
        map.put("out", outAccount);
        map.put("in", inAccount);
        map.put("money", String.valueOf(money.doubleValue()));
        return map;
    }
}
