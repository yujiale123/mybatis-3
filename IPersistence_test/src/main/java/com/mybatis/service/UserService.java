package com.mybatis.service;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public interface UserService {
  public List<User> findAll() throws Exception;

  public User findByCondition(User user) throws Exception;
}
