package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.io.IOException;
import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/11/19
 */
public interface UserMapper {
  /**
   * 查询所有用户
   *
   * @return
   * @throws IOException
   */
  public List<User> findAll() throws IOException;

  /**
   * 多条件组合查询：演示if
   *
   * @param user
   * @return
   */
  public List<User> findByCondition(User user);


  /**
   * 多值查询：演示foreach
   *
   * @param ids
   * @return
   */
  public List<User> findByIds(int[] ids);
}
