package com.lhx.dm.user.mapper;

import com.lhx.dm.user.entity.Commentvideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhx.dm.user.vo.Comments.CommentsVideoVo;
import com.lhx.dm.user.vo.Comments.Comments_reply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lhx
 * @since 2023-05-01
 */
public interface CommentvideoMapper extends BaseMapper<Commentvideo> {

    @Select("select c.id as cid \n" +
            ",c.created_at as created_at,c.content as content,c.uid as uid,\n" +
            "u.user_name as name,\n" +
            "u.face_img as avatar\n" +
            "from commentvideo c LEFT JOIN user u on c.uid = u.id \n" +
            "where c.parent_id =0\n" +
            "LIMIT #{pageSize} OFFSET #{pageNo}")
    @Results({
            @Result(column="cid", property="cid", jdbcType= JdbcType.VARCHAR),
            @Result(column="created_at", property="created_at", jdbcType= JdbcType.DATE),
            @Result(column="content", property="content", jdbcType= JdbcType.VARCHAR),
            @Result(column="avatar", property="avatar", jdbcType= JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
            @Result(column="uid", property="uid", jdbcType= JdbcType.VARCHAR),
    })
    List<CommentsVideoVo> getmainlist(@Param("pageNo")Long pageNo,@Param("pageSize")Long pageSize);

    @Select("select c.id as rid \n" +
            ",c.created_at as created_at,c.content as content,c.uid as uid,\n" +
            "u.user_name as name,\n" +
            "u.face_img as avatar\n" +
            "from commentvideo c LEFT JOIN user u on c.uid = u.id \n" +
            "where c.parent_id !=0")
    @Results({
            @Result(column="rid", property="rid", jdbcType= JdbcType.VARCHAR),
            @Result(column="created_at", property="created_at", jdbcType= JdbcType.DATE),
            @Result(column="content", property="content", jdbcType= JdbcType.VARCHAR),
            @Result(column="avatar", property="avatar", jdbcType= JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
            @Result(column="uid", property="uid", jdbcType= JdbcType.VARCHAR),
    })
    List<Comments_reply> getitemlist();
}
