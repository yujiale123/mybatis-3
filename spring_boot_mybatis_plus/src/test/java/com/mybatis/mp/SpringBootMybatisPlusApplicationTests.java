package com.mybatis.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.mp.mapper.UserMapper;
import com.mybatis.mp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

  @Resource
  private UserMapper userMapper;

  @Test
  void contextLoads() {
  }


  /**
   * 排序操作
   */
  public void orderByTest(){
    QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
    //以年龄的降序排列
    userQueryWrapper.orderByDesc("age");

    List<User> users = userMapper.selectList(userQueryWrapper);
    for (User user : users) {
      System.out.println(user);
    }
  }

}
