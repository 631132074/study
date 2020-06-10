package com.bwl.study.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BW Li
 * @date 2020-05-21 13:12
 * @description
 */
@Data
public class SysRequest <T> implements Serializable {
    private SysParams sysParams;
    private T busParams;


}
