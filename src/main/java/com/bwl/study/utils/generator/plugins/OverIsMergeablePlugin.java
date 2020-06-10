package com.bwl.study.utils.generator.plugins;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * introspectedTableMyBatis3Impl.getGeneratedXmlFiles方法中，isMergeable值被写死为true了
 * 源码如下
 * GeneratedXmlFile gxf =
 * new GeneratedXmlFile
 * (document, this.getMyBatis3XmlMapperFileName(),
 * this.getMyBatis3XmlMapperPackage(),
 * this.context.getSqlMapGeneratorConfiguration().getTargetProject(),
 * true,        //源码此处写死为true,导致每次生成都是在xml文件追加
 * this.context.getXmlFormatter());
 *
 * 在此扩展插件中使用反射获取字段value,然后将值改为false
 *
 * 重新生成xml文件将会覆盖原来的方法
 */

public class OverIsMergeablePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}