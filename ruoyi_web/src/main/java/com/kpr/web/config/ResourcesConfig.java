package com.kpr.web.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用配置
 *
 * @author ruoyi
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {


  /**
   * 跨域配置
   */
  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    // 设置访问源地址
    config.addAllowedOriginPattern("*");
    // 设置访问源请求头
    config.addAllowedHeader("*");
    // 设置访问源请求方法
    config.addAllowedMethod("*");
    // 有效期 1800秒
    config.setMaxAge(1800L);
    // 添加映射路径，拦截一切请求
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);
    // 返回新的CorsFilter
    return new CorsFilter(source);
  }

  /**
   * 利用fastJson替换掉jackson，且解决中文乱码问题
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    FastJsonHttpMessageConverter fastConverter  = new FastJsonHttpMessageConverter();
    FastJsonConfig               fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(
        SerializerFeature.DisableCircularReferenceDetect,
        SerializerFeature.WriteMapNullValue,
        SerializerFeature.WriteNullNumberAsZero,
        SerializerFeature.WriteNullStringAsEmpty,
        SerializerFeature.WriteNullListAsEmpty,
        SerializerFeature.WriteNonStringKeyAsString,
        SerializerFeature.WriteNullBooleanAsFalse,
        SerializerFeature.BrowserCompatible,
        SerializerFeature.WriteDateUseDateFormat);

    //解决Long转json精度丢失的问题
    SerializeConfig serializeConfig = SerializeConfig.globalInstance;
    serializeConfig.put(BigInteger.class, com.alibaba.fastjson.serializer.ToStringSerializer.instance);
    serializeConfig.put(Long.class, com.alibaba.fastjson.serializer.ToStringSerializer.instance);
    serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
    fastJsonConfig.setSerializeConfig(serializeConfig);

    //处理中文乱码问题
    List<MediaType> fastMediaTypes = new ArrayList<>();
    fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

    fastConverter.setSupportedMediaTypes(fastMediaTypes);
    fastConverter.setFastJsonConfig(fastJsonConfig);
    converters.add(fastConverter);
  }
}
