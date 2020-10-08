/*
package com.huanjava.taobao.user.config;

import com.fasterxml.classmate.TypeResolver;
import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;


*/
/**
 * @author: wells
 * @date: 2020/9/25
 * @version: 1.0
 * @Description: Swagger2配置类
 *//*

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
public class Swagger2Config {
    */
/**
     * 是否启用在线接口文档
     *//*

    @Value("${properties.swagger.show:true}")
    private boolean swaggerShow;

    */
/**
     * 这个东西是项目的根路径，也就是“/oauth/token”前面的那一串
     * 这个东西在配置文件里写的，大家也可以直接写死在配置文件中
     *//*

    @Value("${oauth-service-url}")
    private String AUTH_SERVER;

    @Autowired
    private TypeResolver typeResolver;

   */
/* @Bean
    public Docket createRestApi() {
        //添加head参数-access_token
        ParameterBuilder tokenPar = new ParameterBuilder();
//        ParameterBuilder tokenPar2 = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        tokenPar.name(CommonConstant.HEADER_AUTHORIZATION)
                .defaultValue(CommonConstant.HEADER_AUTHORIZATION_VALUE_PRE + "10001")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        parameterList.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .groupName("红豆系统相关接口")
                .select()
                // 扫描指定包中的swagger注解
                .apis(RequestHandlerSelectors.basePackage("com.pilot.ibms.system.controller"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList)
                .apiInfo(apiInfo())
//                .securitySchemes(Collections.singletonList(securityScheme()))
//                .securityContexts(Collections.singletonList(securityContext()))
                // 自定义规则，如果遇到DeferredResult，则把泛型类转成json
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)));
    }
*//*

    */
/**
     * 基本信息
     * @return
     *//*

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基础系统管理 APIs")
                .description("提供用户登录，token续约，退出等接口。")
                .termsOfServiceUrl("http://www.baidu.com/")
                .contact(new Contact("pilot", "", ""))
                .version("1.0")
                .build();
    }

    */
/**
     * 这个类决定了你使用哪种认证方式，我这里使用密码模式
     * 其他方式自己摸索一下，完全莫问题啊
     *//*

    private SecurityScheme securityScheme() {
        GrantType grantType = new ClientCredentialsGrant(AUTH_SERVER + "/oauth/token");
        return new OAuthBuilder()
                .name("swagger")
                .grantTypes(Collections.singletonList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    */
/**
     * 这里设置 swagger2 认证的安全上下文
     *//*

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("swagger", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }

    */
/**
     * 这里是写允许认证的scope
     *//*

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("all", "All scope is trusted!")
        };
    }

    @Bean
    SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId("swagger")
                .clientSecret("swagger")
                .realm("swagger")
                .appName("swagger-app")
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .validatorUrl(null)
                .build();
    }
}
*/
