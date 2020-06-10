package com.bwl.study.service.impl;

import com.bwl.study.dao.mapper.SysUserMapper;
import com.bwl.study.entity.dos.SysUser;
import com.bwl.study.entity.example.SysUserExample;
import com.bwl.study.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BW Li
 * @date 2020-06-02 17:41
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public int add(SysUser user) {
        return sysUserMapper.insertSelective(user);
    }

    @Override
    public List<SysUser> find() {

        SysUserExample userExample = new SysUserExample();
        return sysUserMapper.selectByExample(userExample);
    }

    @Override
    public SysUser findById(long id) {

        return sysUserMapper.selectByPrimaryKey(id);
    }
}
