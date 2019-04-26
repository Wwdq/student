package ServiceIml;

import Mapper.UserMapper;
import Pojo.Tip;
import Pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserService {
    public User login(String id, String password) throws IOException {
        User user=new User();
        user.setId(id);
        user.setPassword(password);

        InputStream ss = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        UserMapper a=sqlSession.getMapper(UserMapper.class);
        return a.selectUser(user);
    }
   public List<Tip> watchTip() throws IOException {
       InputStream ss = Resources.getResourceAsStream("mybatis.xml");
       SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
       SqlSession sqlSession=my.openSession();
       UserMapper a = sqlSession.getMapper(UserMapper.class);
       return a.selectTip();
   }
   public String updatePassword(User user,String password) throws IOException {
       InputStream ss = Resources.getResourceAsStream("mybatis.xml");
       SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
       SqlSession sqlSession=my.openSession();
       UserMapper a = sqlSession.getMapper(UserMapper.class);
       if (a.updatePassword(user, password)>0) {
           sqlSession.commit();
              return password;
       }
       return null;
   }


}
