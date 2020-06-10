package com.bwl.study.entity.dos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* @Description： sys_permission表
* @Author： deo
* @Date： 2020-06-09 13:41:38
*/
@Data
public class SysPermission implements Serializable {
    /** 
     * 编号
     * (主键ID)
     */
    @ApiModelProperty(value="编号")
    private Long id;

    /** 
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /** 
     * 资源类型(1.菜单 2.按钮或文本块)
     */
    @ApiModelProperty(value="资源类型(1.菜单 2.按钮或文本块)")
    private Boolean type;

    /** 
     * 父编号
     */
    @ApiModelProperty(value="父编号")
    private Long parentId;

    /** 
     * 父编号列表
     */
    @ApiModelProperty(value="父编号列表")
    private String parentIds;

    /** 
     * 权限字符串
     */
    @ApiModelProperty(value="权限字符串")
    private String permission;

    /** 
     * 图标
     */
    @ApiModelProperty(value="图标")
    private String icon;

    /** 
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /** 
     * 是否有效
     */
    @ApiModelProperty(value="是否有效")
    private Boolean status;

    /** 
     * 权限配置
     */
    @ApiModelProperty(value="权限配置")
    private Object config;

    private static final long serialVersionUID = 1L;
}