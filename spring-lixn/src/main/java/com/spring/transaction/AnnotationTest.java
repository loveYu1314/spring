package com.spring.transaction;

import com.spring.transaction.service.AccountAnnotationService;
import com.spring.transaction.service.AccountAspectjService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @author Rubicon
 * @version v2.0
 * @date 2018/11/12 9:39
 * @desc 说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextAnnotation.xml")
public class AnnotationTest {
    // 使用 Aspectj 属于自动代理，自动代理就会在产生 service 时已经增加了代理属性
    @Autowired
    private AccountAnnotationService iAccountAnnotationService;

    @Test
    public void annotationTest() {
        iAccountAnnotationService.annotationTransaction("李四", "张三", new BigDecimal(20));
    }
}
