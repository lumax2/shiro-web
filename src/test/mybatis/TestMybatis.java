package mybatis;

import com.yoozoo.shiroweb.mapper.UserMapper;
import com.yoozoo.shiroweb.model.form.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Hao on 2018/3/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMybatis {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testFindByName(){

        User user = userMapper.findByName("eric");
        System.out.println("User :"+user);
    }
}
