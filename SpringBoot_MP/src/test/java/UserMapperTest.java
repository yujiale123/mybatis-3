import com.mybatis.mp.mapper.UserMapper;
import com.mybatis.mp.pojo.User;

/**
 * @program: mybatis
 * @author: yjl
 * @created: 2021/12/01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
  @Autowired
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    List<User> userList = userMapper.selectList(null);
    for (User user : userList) { System.out.println(user);
    }
  }
}
