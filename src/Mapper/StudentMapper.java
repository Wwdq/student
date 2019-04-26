package Mapper;

import Pojo.Score;
import Pojo.Student;
import Pojo.Tip;
import Pojo.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    //查看自己的信息
    @Select("select * from student where sno=#{id};" )
    Student selectMy(User user);
    //同学的信息 同学录
    @Select("select * from student where cno=#{cno};")
    List<Student> selectMate(Student student);
    //修改自己的信息 以修改QQ（联系方式为例）
    @Update("update student set QQ=#{1} where sno=#{0.sno};")
    int updateMy(Student me,String QQ);
    @Select("select * from tip")
     List<Tip> selectTip();
    @Select("select *from score where sno=#{0.sno} and eno=#{1} ")
    Score selectScore(Student student, int id);
    @Select("select * from score where eno=#{0}")
    List<Score> selectAll(int id);
    @Select({ "call stu_pro(#{storeCode,mode=IN,jdbcType=VARCHAR},"
            + "#{tsCode,mode=IN,jdbcType=VARCHAR},"
            + "#{purchaseOrderNumber,mode=OUT,jdbcType=VARCHAR})" })
    @Options(statementType= StatementType.CALLABLE)
    void getPurchaseOrderNumber(Map<String,String> params);

}
