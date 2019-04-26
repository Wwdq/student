package Mapper;

import Pojo.Course;
import Pojo.Grade;
import Pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {
    @Select("select * from class where cno=#{cno}")
    Grade selectGrade(Student student);
    @Select("select * from class where cno=#{cno}")
    Grade selectGrade1(Course course);
    @Select("select * from class where cno=#{0}")
    Grade selectGrade2(int cno);


}
