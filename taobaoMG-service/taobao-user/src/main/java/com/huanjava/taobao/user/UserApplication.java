package com.huanjava.taobao.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author:wells
 * @since:2020/9/22
 */
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
//        SpringApplication.run(UserApplication.class);
        System.out.println(LocalDate.of(1999,11,11).plusDays(1000));
    }
}
