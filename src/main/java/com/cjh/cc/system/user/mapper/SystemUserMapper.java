package com.cjh.cc.system.user.mapper;

import com.cjh.cc.system.user.model.SystemUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemUserMapper {

    public int saveUser(SystemUser user);


}
