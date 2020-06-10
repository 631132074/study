package com.bwl.study.entity.dos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* @Description： sys_user表
* @Author： deo
* @Date： 2020-06-09 13:41:38
*/
@Data
public class SysUser implements Serializable {
    /** 
     * 编号
     * (主键ID)
     */
    @ApiModelProperty(value="编号")
    private Long id;

    /** 
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /** 
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /** 
     * 盐值
     */
    @ApiModelProperty(value="盐值")
    private String salt;

    /** 
     * 角色列表
     */
    @ApiModelProperty(value="角色列表")
    private String roleIds;

    /** 
     * 是否锁定
     */
    @ApiModelProperty(value="是否锁定")
    private Integer locked;

    /** 
     */
    @ApiModelProperty(value="creat_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date creatTime;

    private static final long serialVersionUID = 1L;
}