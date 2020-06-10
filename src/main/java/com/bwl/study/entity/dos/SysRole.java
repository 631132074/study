package com.bwl.study.entity.dos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* @Description： sys_role表
* @Author： deo
* @Date： 2020-06-09 13:41:38
*/
@Data
public class SysRole implements Serializable {
    /** 
     * 编号
     * (主键ID)
     */
    @ApiModelProperty(value="编号")
    private Long id;

    /** 
     * 唯一标识
     */
    @ApiModelProperty(value="唯一标识")
    private String role;

    /** 
     * 角色名称
     */
    @ApiModelProperty(value="角色名称")
    private String name;

    /** 
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;

    /** 
     * 状态 1.正常 0.禁用
     */
    @ApiModelProperty(value="状态 1.正常 0.禁用")
    private Boolean status;

    /** 
     * 资源编号列表
     */
    @ApiModelProperty(value="资源编号列表")
    private String permissionIds;

    private static final long serialVersionUID = 1L;
}