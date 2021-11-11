package com.lcy.dao;

import com.lcy.po.RegionalOperator;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘呈洋
 */
public interface RegionalOperatorDao {
    /**
     * 用户登录
     */
    public RegionalOperator regionalOperatorLogin(@Param(value = "userName") String userName, @Param(value = "password") String password);
}
