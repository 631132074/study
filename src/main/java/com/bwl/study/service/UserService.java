package com.bwl.study.service;


import com.bwl.study.entity.dos.SysUser;

import java.util.List;

/**
 * @author BW Li
 * @date 2020-06-02 17:40
 * @description
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user 用户实体
     * @return 执行结果
     */
    int add(SysUser user);

    /**
     * 查找用户列表
     *
     * @return 执行结果
     */
    List<SysUser> find();

    /**
     * 查找用户
     *
     * @param id 用户id
     * @return 执行结果
     */
    SysUser findById(long id);

}
