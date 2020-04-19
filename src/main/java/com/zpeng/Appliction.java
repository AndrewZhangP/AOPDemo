package com.zpeng;

import com.zpeng.aspect.MyAspect;
import com.zpeng.intercept.Impl.InterceptorImpl;
import com.zpeng.pojo.User;
import com.zpeng.proxy.ProxyBean;
import com.zpeng.service.impl.UserServiceImpl;
import com.zpeng.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.zpeng"})
public class Appliction {

    @Bean
    public MyAspect initMyAspect(){
        return new MyAspect();
    }
    public static void main(String[] args){
//        UserService userService = new UserServiceImpl();
//
//        UserService proxy = (UserService) ProxyBean.getProxyBean(userService,new InterceptorImpl());
//
//        User user = new User("1","2","3");
//        proxy.printUser(user);
//
//        System.out.println("+++++++");

        SpringApplication.run(Appliction.class);
    }
}
