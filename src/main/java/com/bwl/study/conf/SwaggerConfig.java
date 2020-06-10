package com.bwl.study.conf;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author BW Li
 * @date 2020-06-03 14:05
 * @description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.description}")
    private String description;
    @Value("${swagger2.version}")
    private String version;
    @Value("${swagger2.base-package}")
    private String basePackage;

    /**
     * swagger2的配置文件，配置swagger2的一些基本的内容，比如扫描的包等等
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描的包路径
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 构建 api 文档的详细信息函数
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }
}
