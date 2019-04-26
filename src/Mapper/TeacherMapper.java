package Mapper;

import Pojo.ScoreTip;
import Pojo.Teacher;
import Pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TeacherMapper
{
    @Select("select * from teacher where tno=#{id}")
    Teacher selectMe(User user);
    //修改自己的信息 以修改QQ（联系方式为例）
    @Update("update teacher set QQ=#{1} where tno=#{0.tno};")
    int updateMy(Teacher me,String QQ);
    @Select("select * from teach_view2 where eno =#{0}")
    ScoreTip selectTip(int eno);



}
