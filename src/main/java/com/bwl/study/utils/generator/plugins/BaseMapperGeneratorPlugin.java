package com.bwl.study.utils.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class BaseMapperGeneratorPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * Mapper继承BaseMapper,清空重复冗余方法
     */
    @Override
    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        /**
         * 获取主键对应的java数据类型(如果有联合主键什么的需要调整一下)
         */
        String primaryKeyType = introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().getFullyQualifiedName();

        /**
         * 生成继承BaseMapper代码
         */
        FullyQualifiedJavaType baseMapper = new FullyQualifiedJavaType("BaseMapper<"
                + introspectedTable.getBaseRecordType() + ","
                + introspectedTable.getExampleType() + ","
                + primaryKeyType + ">");

        /**
         * 引入父类的代码 import xxx.xx;
         */
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(
                "com.bwl.study.dao.BaseMapper");

        /**
         * 添加 extends BaseMapper
         */
        interfaze.addSuperInterface(baseMapper);

        /**
         * 添加引入
         */
        interfaze.addImportedType(imp);

        /**
         * 格式化内容
         */
        interfaze.getFormattedContent();
        /**
         * 清除自动生成的方法
         */
        interfaze.getMethods().clear();

        /**
         * 清除自动生成的注解
         */
        interfaze.getAnnotations().clear();
        return true;
    }

}