package com.spring.transaction;

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
@ContextConfiguration("classpath:applicationContextProxy.xml")
public class ProxyTest {
    //    当使用 proxy 代理层去处理事务时，就不能直接注入原来的 service 的名字了，需要使用代理事务名字
    //    @Autowired
    //    private AccountProxyService iAccountProxyService;

    @Resource(name = "serviceProxy")
    private AccountProxyService iAccountProxyService;

    @Test
    public void proxyTest() {
        iAccountProxyService.proxyTransaction("李四", "张三", new BigDecimal(20));
    }
}
