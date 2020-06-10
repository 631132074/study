package com.bwl.study.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author BW Li
 * @date 2020-05-21 13:12
 * @description
 */
@Data
public class SysParams implements Serializable {
    private String version;
    private Integer source;
    private String ip;
    private String correlationId;
    private String token;
}
