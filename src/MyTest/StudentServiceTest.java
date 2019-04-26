package MyTest;

import Mapper.StudentMapper;
import Pojo.Student;
import Pojo.Tip;
import Pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class StudentServiceTest {


    Student showMe(User user) throws IOException {

        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper a=sqlSession.getMapper(StudentMapper.class);
        Student me=a.selectMy(user);
        System.out.println(me);
        return me;
    }
    @Test
    void showMate(User user) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student me=showMe(user);
        List<Student> mate = mapper.selectMate(me);
        for(Student a:mate)
            System.out.println(a);
    }
    @Test
    void  showTip() throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Tip> tip=mapper.selectTip();
        for(Tip a:tip)
        System.out.println(a);
    }
}