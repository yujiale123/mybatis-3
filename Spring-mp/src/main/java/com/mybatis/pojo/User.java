package com.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
@Data // getter setter toString
@NoArgsConstructor //生成无参构造
@AllArgsConstructor // 生成全参构造
@TableName("user")
public class User {

  private Long id;
  private String name;
  private Integer age;
  private String email;

}
