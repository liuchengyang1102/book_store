package com.lcy.dao;

import com.lcy.po.Book;
import com.lcy.po.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface BusinessDao {
    /**
     * 商家登录
     */
    public Business businessLogin(@Param(value = "username") String username, @Param(value = "password") String password);

    /**
     * 商家注册
     */
    public int addBusiness(@Param(value = "userName") String userName, @Param(value = "password") String password,
                            @Param(value = "name") String name, @Param(value = "address") String address,
                            @Param(value = "type") String type, @Param(value = "registeredCapital") double registeredCapital,
                            @Param(value = "logPicture") String logPicture);

    /**
     * 商家收款
     * @param businessId
     * @param price
     * @return
     */
    public int receive(@Param(value = "businessId") int businessId, @Param(value = "price") double price);

    /**
     * 查询待审核商家
     */
    List<Business> queryBusiness(@Param(value = "area")String area);
}
