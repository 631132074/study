package com.bwl.study.utils.generator.enums;

/**
 * @author BW Li
 * @date 2020-06-03 13:22
 * @description
 */
public enum Annotation {
    DATA("@Data", "lombok.Data"),
    Mapper("@Mapper", "org.apache.ibatis.annotations.Mapper"),
    Param("@Param", "org.apache.ibatis.annotations.Param"),
    ApiModel("@ApiModel", "io.swagger.annotations.ApiModel"),
    ApiModelProperty("@ApiModelProperty", "io.swagger.annotations.ApiModelProperty"),
    Length("@Length", "org.hibernate.validator.constraints.Length"),
    JsonFormat("@JsonFormat", "com.fasterxml.jackson.annotation.JsonFormat");

    private String annotation;
    private String clazz;

    private Annotation(String annotation, String clazz) {
        this.annotation = annotation;
        this.clazz = clazz;
    }

    public String getAnnotation() {
        return this.annotation;
    }

    public String getClazz() {
        return this.clazz;
    }
}
