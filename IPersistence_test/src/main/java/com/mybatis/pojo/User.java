package com.mybatis.pojo;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public class User {
  private Integer id;

  private String username;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", username='" + username + '\'' +
      '}';
  }
}
