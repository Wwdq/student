package MyTest;

import Mapper.UserMapper;
import Pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void updatePassword() throws IOException {
        InputStream ss = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        UserMapper a = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId("1001");
        String password = "123456";
        if (a.updatePassword(user, password)>0) {
            System.out.println("成功");
            sqlSession.commit();
        }
        else
        System.out.println("失败");
    }

    }
