package com.lhx.dm.user.mapper;


import com.lhx.dm.user.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageDao {

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO message VALUES (#{id},#{content},#{size},#{color},#{bold},#{italic}," +
            " #{position},#{ip},#{name},#{time},#{available})")
    void saveMessage(Message message);

    @Select("SELECT * FROM message")
    List<Message> findAll();
}
