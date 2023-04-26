package com.dingdangmaoup.mini.platform.bootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.dingdangmaoup.mini.platform", "com.alibaba.cola"})
public class BootstrapApplication {


  public static void main(String[] args) {
    SpringApplication.run(BootstrapApplication.class, args);
  }


}
