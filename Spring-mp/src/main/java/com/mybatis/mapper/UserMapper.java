package com.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.pojo.User;

import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
public interface UserMapper extends BaseMapper<User> {

  List<User> findAll();
}
