package Mapper;

import Pojo.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface ScoreMapper {
   @Insert("insert score values(default,#{eno},#{sno},#{sc})")
    int insertScore(Score score);

   @Update("update score set sc=#{sc} where eno=#{eno} and sno=#{sno}")
    int updateScore(Score score);

    @Select("select * from score where eno=#{eno} and sno=#{sno}")
    Score selectScore(Score score);

}
