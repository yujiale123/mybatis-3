package com.mybatis.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.mp.pojo.User;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
public interface UserMapper extends BaseMapper<User> {

  /**
   * 自定义findById方法
   *
   * @param id
   * @return
   */
  public User findById(Long id);
}
