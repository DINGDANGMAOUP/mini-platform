package com.dingdangmaoup.mini.platform.adapter.web;

import com.alibaba.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {

  @RequestMapping("/test")
  public SingleResponse<String> test() {
    return SingleResponse.of("Hello World");
  }
}
