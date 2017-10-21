package com.cjh.cc.system.user.service.impl;

import com.cjh.cc.system.user.mapper.SystemUserMapper;
import com.cjh.cc.system.user.model.SystemUser;
import com.cjh.cc.system.user.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Transactional
    @Override
    public int saveUser(SystemUser user)throws  Exception{



      return this.systemUserMapper.saveUser(user);
    }

}
