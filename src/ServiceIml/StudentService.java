package ServiceIml;

import Mapper.ClassMapper;
import Mapper.ExamMapper;
import Mapper.ScoreMapper;
import Mapper.StudentMapper;
import Pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    //查看自己的信息
    public Student showMe(User user) throws IOException {

        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper a=sqlSession.getMapper(StudentMapper.class);
        ClassMapper b = sqlSession.getMapper(ClassMapper.class);
        Student me=a.selectMy(user);
        Grade grade = b.selectGrade(me);
        me.setGrade(grade);
        return me;
    }
    //查看同学的信息
    public List<Student> showMate(User user) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        ClassMapper b = sqlSession.getMapper(ClassMapper.class);
        Student me=showMe(user);
        Grade grade = b.selectGrade(me);
        List<Student> mate = mapper.selectMate(me);
        for(Student student:mate){
            student.setGrade(grade);
        }
        return mate;
    }
    // 修改自己的QQ号

    public List<Tip>  showTip() throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Tip> tip=mapper.selectTip();
        return tip;
    }
    public List<Score> selectScore(User user) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        ExamMapper examMapper = sqlSession.getMapper(ExamMapper.class);
        ScoreMapper scoreMapper = sqlSession.getMapper(ScoreMapper.class);
        Student me =showMe(user);
        List<Exam> exams = examMapper.selectExam1(me);
        List<Score>scores=new ArrayList<>();
        for(int i=0;i<exams.size();i++){
            Score score=new Score();
            score.setEno(exams.get(i).getEno());
            score.setSno(me.getSno());

            Score score1 = scoreMapper.selectScore(score);
            if(score1!=null) {


                score1.setExam(exams.get(i));
                scores.add(score1);
            }
            else {
                score.setExam(exams.get(i));
                scores.add(score);
            }
        }
        return scores;

    }


    public void updateQQ(User user,String QQ) throws IOException {
        InputStream ss= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory my = new SqlSessionFactoryBuilder().build(ss);
        SqlSession sqlSession=my.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.updateMy(showMe(user),QQ);
        Logger logger = Logger.getLogger(StudentService.class);
        logger.error(showMe(user).getName()+"修改了QQ号");
        sqlSession.commit();

    }
}
