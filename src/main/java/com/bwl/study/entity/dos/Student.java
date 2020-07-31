package com.bwl.study.entity.dos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* @Description： student表
* @Author： deo
* @Date： 2020-07-23 16:27:40
*/
@Data
public class Student implements Serializable {
    /** 
     * 编号
     * (主键ID)
     */
    @ApiModelProperty(value="编号")
    private Integer studentId;

    /** 
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /** 
     * 电话
     */
    @ApiModelProperty(value="电话")
    private String phone;

    /** 
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    /** 
     * 性别
     */
    @ApiModelProperty(value="性别")
    private Integer sex;

    /** 
     * 状态(0:正常,1:锁定)
     */
    @ApiModelProperty(value="状态(0:正常,1:锁定)")
    private Integer locked;

    /** 
     * 存入数据库的时间
     */
    @ApiModelProperty(value="存入数据库的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreated;

    /** 
     * 修改的时间
     */
    @ApiModelProperty(value="修改的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}