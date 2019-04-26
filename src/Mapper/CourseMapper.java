package Mapper;

import Pojo.Course;
import Pojo.Teacher;
import Pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Select("select * from course where tno=#{tno}")
    List<Course> selectCourse(Teacher teacher);

}
