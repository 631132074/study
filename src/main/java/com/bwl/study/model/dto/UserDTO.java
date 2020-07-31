package com.bwl.study.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * @author BW Li
 * @date 2020-05-21 11:59
 * @description
 */
@Data
public class UserDTO implements Serializable {

    @Min(value = 1, message = "不可小于1")
    @NotNull
    private Long userId;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatTime;
}
