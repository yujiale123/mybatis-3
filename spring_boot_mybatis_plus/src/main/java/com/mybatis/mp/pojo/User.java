package com.mybatis.mp.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
@Data
@NoArgsConstructor //生成无参构造
@AllArgsConstructor // 生成全参构造
@TableName("tb_user")
public class User {

  private Long id;
  private String name;
  private Integer age;

  private String mail;

  private String address;

  private Integer version;

  private Integer deleted;
}
