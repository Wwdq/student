package Mapper;

import Pojo.Exam;
import Pojo.Student;
import Pojo.Teacher;
import Pojo.Tip;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {
    @Select("select * from teacher")
    List<Teacher>selectTeacher();
    @Select("select * from student")
    List<Student>selectStudent();

    @Select("select *from exam ")
    List<Exam> selectExam();

   @Delete("delete from student where sno=#{0} ")
    int  deleteStudent(String sno);
   @Delete("delete from teacher where tno=#{0}")
    int deleteTeacher(String tno);
    @Delete("delete from tip where id=#{id}")
    int deleteTip(int id);
    @Insert("insert teacher values(#{tno},#{name},#{QQ},#{birth})")
    int insertTeacher(Teacher teacher);
    @Insert("insert student values(#{sno},#{name},#{QQ},#{birth},#{cno})")
    int insertStudent(Student student);
    @Insert("insert tip values(#{id},#{tstring})")
    int insertTip(Tip tip);
    @Update("update student set sno=#{0} where sno='2013'")
    int updateStudent(String sno);  // 更改学生信息
    @Update("update student set cno=#{0} where sno='2013'")
    int updateStudent1(int cno);  // 更改学生信息
    @Update("update teacher set tno=#{1} where tno=#{0}")
    int updateTeahcer(String tno,String newNumber ); //更改老师信息，以工号为例
    @Update("update tip set tstring=#{1} where id=#{0}")
    int updateTip(int  id,String tstring  );   //更新公告 以更改公告描述为例


}
