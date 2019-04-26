package ServiceIml;

import Mapper.*;
import Pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.awt.peer.TrayIconPeer;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AdminService {
    InputStream ss= Resources.getResourceAsStream("mybatis.xml");
    SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
    SqlSession sqlSession=my.openSession();
    AdminMapper admin = sqlSession.getMapper(AdminMapper.class);
    public AdminService() throws IOException {
    }

    public List<Teacher> selectTeacher() throws IOException {
        CourseMapper b = sqlSession.getMapper(CourseMapper.class);
        ClassMapper c = sqlSession.getMapper(ClassMapper.class);
        List<Teacher> teachers=admin.selectTeacher();
        for(Teacher teacher:teachers){
            List<Course> courses=b.selectCourse(teacher);
            for(Course course:courses){
                Grade grade= c.selectGrade1(course);
                course.setGrade(grade);
            }
            teacher.setCourse(courses);
        }
        return teachers;
    }
    public List<Student> selectStudent(){
        List<Student> students = admin.selectStudent();
        ClassMapper b = sqlSession.getMapper(ClassMapper.class);
        for(Student student:students){
            Grade grade = b.selectGrade(student);
            student.setGrade(grade);

        }
         return students;

    }
    public  List<Tip> selectTip(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Tip> tips = userMapper.selectTip();
        return tips;
    }
    public List<Exam> selectExam(){
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        List<Exam> exams = admin.selectExam();
        for(Exam exam:exams){
            exam.setGrade(classMapper.selectGrade2(exam.getCno()));
        }
        return exams;


    }
    public int deleteStudentService(String sno){
        int a = admin.deleteStudent(sno);
        if(a>0){
            Logger logger = Logger.getLogger(AdminService.class);
            logger.debug("删除学生成功");
        }
        return a;


    }


    public int deleteTeacherService(String tno) {
        int a = admin.deleteTeacher(tno);
        if(a>0){
            Logger logger = Logger.getLogger(AdminService.class);
            logger.debug("删除老师成功");
         }
         return a;
    }

    public int deleteTipService(int id) {
        int a = admin.deleteTip(id);
        if(a>0){
            Logger logger = Logger.getLogger(AdminService.class);
            logger.debug("删除公告成功");
        }
        return a;
    }

    public void updateStudent(String sno, int nian, int ban) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        AdminMapper admin = sqlSession.getMapper(AdminMapper.class);
        admin.updateStudent(sno);
        admin.updateStudent1((nian-1)*2+ban);
        sqlSession.commit();
    }

    public void insertStudent(String sno, int nian, int ban, String name, String qq) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        AdminMapper admin = sqlSession.getMapper(AdminMapper.class);
        Student student=new Student();
        student.setCno((nian-1)*2+ban);
        student.setSno(sno);
        student.setName(name);
        student.setQQ(qq);
        admin.insertStudent(student);
        sqlSession.commit();
    }
}
