package Mapper;

import Pojo.Tip;
import Pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where id=#{id}and password=#{password}")
    User selectUser(User user);

    @Select("select * from tip")
    List<Tip> selectTip();

    @Update("update user set password=#{1} where id=#{0.id} ")
    int updatePassword(User user,String password);




}
