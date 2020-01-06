package com.spring.transaction;

import com.spring.transaction.service.AccountAspectjService;
import com.spring.transaction.service.AccountProxyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/12 9:39
 * @desc 说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextAspectj.xml")
public class AspectjTest {
    // 使用 Aspectj 属于自动代理，自动代理就会在产生 service 时已经增加了代理属性
    @Autowired
    private AccountAspectjService iAccountAspectjService;

    @Test
    public void aspectjTest() {
        iAccountAspectjService.aspectjTransaction("李四", "张三", new BigDecimal(80));
    }
}
