package com.bwl.study.utils.generator.plugins;

import com.bwl.study.utils.generator.enums.Annotation;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 生成数据库字段注释
 * 类名前加自定义注释
 * 注释增加数据字段是否为必填项
 * 注释增加数据字段是否有默认值
 * 注释增加属性是否为主健
 */
public class RemarksCommentGenerator extends DefaultCommentGenerator {

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        classAnnotation(topLevelClass, introspectedTable);
        Set<FullyQualifiedJavaType> set = new HashSet();
        set.add(new FullyQualifiedJavaType(Annotation.ApiModel.getClazz()));
        set.add(new FullyQualifiedJavaType(Annotation.DATA.getClazz()));
        topLevelClass.addImportedTypes(set);
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.ApiModelProperty.getClazz()));
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.Length.getClazz()));
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.JsonFormat.getClazz()));
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remark = introspectedColumn.getRemarks();
        field.addJavaDocLine("/** ");
        if (!StringUtils.isEmpty(remark)) {
            field.addJavaDocLine(" * ".concat(remark));
        }

        String columnName = introspectedColumn.getActualColumnName();
        List<IntrospectedColumn> primaryKey = introspectedTable.getPrimaryKeyColumns();
        Iterator var7 = primaryKey.iterator();

        while(var7.hasNext()) {
            IntrospectedColumn pk = (IntrospectedColumn)var7.next();
            if (columnName.equals(pk.getActualColumnName())) {
                field.addJavaDocLine(" * (主键ID)");
            }
        }

        field.addJavaDocLine(" */");
        if (StringUtils.isEmpty(introspectedColumn.getRemarks())) {
            field.addAnnotation(Annotation.ApiModelProperty.getAnnotation() + "(value=\"" + introspectedColumn.getActualColumnName() + "\")");
        } else {
            field.addAnnotation(Annotation.ApiModelProperty.getAnnotation() + "(value=\"" + introspectedColumn.getRemarks() + "\")");
        }

        String a = field.getType().getShortName();
        if ("Date".equals(a) && introspectedColumn.getJdbcTypeName() == "TIMESTAMP") {
            field.addAnnotation(Annotation.JsonFormat.getAnnotation() + "(pattern = \"yyyy-MM-dd HH:mm:ss\",timezone=\"GMT+8\")");
        }

        if ("Byte".equals(a)) {
            field.setType(new FullyQualifiedJavaType("java.lang.Integer"));
        }

    }

    public static void classAnnotation(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        String tableRemarks = introspectedTable.getRemarks();
        topLevelClass.addJavaDocLine("/**");
        if (!StringUtils.isEmpty(tableRemarks)) {
            topLevelClass.addJavaDocLine("* @Description： " + tableRemarks + "表(" + tableName + ")");
        } else {
            topLevelClass.addJavaDocLine("* @Description： " + tableName + "表");
        }

        topLevelClass.addJavaDocLine("* @Author： " + System.getProperty("user.name"));
        topLevelClass.addJavaDocLine("* @Date： " + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
        topLevelClass.addJavaDocLine("*/");
    }
}