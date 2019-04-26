package MyTest;

import Mapper.ClassMapper;
import Mapper.CourseMapper;
import Mapper.ExamMapper;
import Mapper.TeacherMapper;
import Pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceTest {


    public Teacher selectMe(User user) throws IOException {
        System.out.println("业务层被调用类");
        InputStream ss = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession = my.openSession();
        TeacherMapper a = sqlSession.getMapper(TeacherMapper.class);
        CourseMapper b = sqlSession.getMapper(CourseMapper.class);
        ClassMapper c = sqlSession.getMapper(ClassMapper.class);
        Teacher me = a.selectMe(user);
        List<Course> courses = b.selectCourse(me);
        if (courses != null && courses.size() != 0) {
            for (Course course : courses) {
                Grade grade = c.selectGrade1(course);
                course.setGrade(grade);
            }
        }
        me.setCourse(courses);

        return me;
    }

    @Test
    void selectExam() throws IOException {
        User user = new User();
        user.setId("1005");
        Teacher teacher = selectMe(user);
        List<List<Exam>> listList = new ArrayList<>();
        List<Exam> exams = new ArrayList<>();
        List<Course> courses = teacher.getCourse();
        InputStream ss = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession = my.openSession();
        ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
        for (Course course : courses) {
            exams = examMapper.selectExam(course);
            if (exams != null && exams.size() != 0)
                listList.add(exams);
        }
    }
}
