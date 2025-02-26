import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringMP {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void test(){

    List<User> users = userMapper.selectList(null);
    for (User user : users) {
      System.out.println(user);
    }
  }
}
