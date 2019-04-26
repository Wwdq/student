package Mapper;

import Pojo.Course;
import Pojo.Exam;
import Pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExamMapper {
    @Select("select *from exam where cname=#{cname} and cno=#{cno}")
    List<Exam> selectExam(Course coures);
    @Select("select *from exam where cno=#{cno}")
    List<Exam> selectExam1(Student student);
    @Select("select * from exam where eno=#{0}")
     Exam  findExam(int id);

    @Select("select * from student where cno=#{cno}")
    List<Student> findStduent(Exam exam);
}
