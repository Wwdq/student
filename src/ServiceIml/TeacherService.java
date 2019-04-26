package ServiceIml;

import Mapper.*;
import Pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    public Teacher selectMe(User user) throws IOException {
        System.out.println("业务层被调用类");
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        TeacherMapper a=sqlSession.getMapper(TeacherMapper.class);
        CourseMapper b = sqlSession.getMapper(CourseMapper.class);
        ClassMapper c = sqlSession.getMapper(ClassMapper.class);
        Teacher me=a.selectMe(user);
        List<Course> courses=b.selectCourse(me);
        if(courses!=null&&courses.size()!=0){
            for(Course course:courses) {
               Grade grade= c.selectGrade1(course);
                course.setGrade(grade);
            }
        }
        me.setCourse(courses);

        return me;
    }
    public List<Course> selectExam(User user) throws IOException {
        Teacher teacher=selectMe(user);
        List<Exam>exams=new ArrayList<>();
        List<Course> courses=teacher.getCourse();
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
        for(Course course:courses){
            exams = examMapper.selectExam(course);
            if(exams!=null&& exams.size()!=0)
                 course.setExams(exams);
        }
        return courses;
    }
    public Exam scoreExam(int id) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        ScoreTip scoreTip = teacherMapper.selectTip(id);
        Exam exam = examMapper.findExam(id);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students=examMapper.findStduent(exam);
        List<Score> scores=new ArrayList<>();
        scoreTip.setBai(((double)scoreTip.getNumber()/scoreTip.getTotal()));
        for(Student s:students){
            Score score = studentMapper.selectScore(s, id);
            if(score==null){
                score=new Score();
                score.setEno(id);
                score.setExam(exam);
                score.setSno(s.getSno());
                score.setSc(0);
            }
            scores.add(score);
        }
        exam.setScores(scores);
        exam.setStudents(students);
        exam.setScoreTip(scoreTip);
        return exam;

    }

    //老师 执行打分操作时，对分数表进行更新
    public int insertScore(List<Score> scores) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        for(Score s:scores){
            if(scoreMapper.selectScore(s)==null)
                scoreMapper.insertScore(s);      //第一次是插入操作
            else
                scoreMapper.updateScore(s);       //第一次以后就是更新分数操作了
        }
        sqlSession.commit();
        return 1;
    }

    public void updateQQ(User user,String QQ) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        teacherMapper.updateMy(teacherMapper.selectMe(user),QQ);
        Logger logger = Logger.getLogger(StudentService.class);
        logger.error(selectMe(user).getName()+"修改了QQ号");
        sqlSession.commit();
    }
}
