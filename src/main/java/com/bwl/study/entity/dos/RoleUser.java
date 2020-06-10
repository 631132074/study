package com.bwl.study.entity.dos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* @Description： role_user表
* @Author： deo
* @Date： 2020-06-09 13:41:38
*/
@Data
public class RoleUser implements Serializable {
    /** 
     * id
     * (主键ID)
     */
    @ApiModelProperty(value="id")
    private Long id;

    /** 
     * userid
     */
    @ApiModelProperty(value="userid")
    private Long userid;

    /** 
     * roleid
     */
    @ApiModelProperty(value="roleid")
    private Long roleid;

    private static final long serialVersionUID = 1L;
}