package com.spring.transaction.dao;

import com.spring.transaction.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    int outAccount(@Param("outAccount") String outAccount,@Param("reduce") BigDecimal reduce);

    int inAccount(@Param("inAccount") String inAccount,@Param("add") BigDecimal add);
}