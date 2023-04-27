package com.dingdangmaoup.mini.platform.domain.model;

import lombok.Data;

@Data
public class User {

  private Long userId;
  private String username;
  private String password;
  private String phone;
  private String email;
  private String salt;
}
