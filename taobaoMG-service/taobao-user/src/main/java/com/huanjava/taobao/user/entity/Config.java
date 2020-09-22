package com.huanjava.taobao.user.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目相关
 * </p>
 *
 * @author:wells
 * @since:2020/9/11
 */
@Component
@Data
public class Config {


    @Value(value = "${config.systemName}")
    private String systemName;

    @Value(value = "${config.uploadPath}")
    private String uploadPath;


}
