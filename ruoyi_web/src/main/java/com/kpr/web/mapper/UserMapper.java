package com.kpr.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kpr.web.po.UserPo;
import org.apache.ibatis.annotations.Param;

/**
 * @author wl
 */
public interface UserMapper extends BaseMapper<UserPo> {

    /**
     * 查询用户余额 （锁）
     *
     * @param userId 用户id
     * @return 余额
     */
    UserPo selectForUpdate(@Param("userId") Long userId);

}
