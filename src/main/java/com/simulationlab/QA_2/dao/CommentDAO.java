package com.simulationlab.QA_2.dao;

import com.simulationlab.QA_2.model.Comment;
import com.simulationlab.QA_2.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
public interface CommentDAO {
    String TABLE_NAME = "comment";
    String INSERT_FIELDS = "user_id, content, created_date, entity_id, entity_type, status";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{userId}, #{content}, #{createdDate}, #{entityId}, #{entityType}, #{status})"})
    int addComment(Comment comment);

    @Update({"update ", TABLE_NAME, " set status = #{status} where entity_id = #{entityId} and entity_type = #{entityType}"})
    void updateStatus(@Param("entityId") int entityId, @Param("entityType") int entityType, @Param("status") int status);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where entity_id = #{entityId} and entity_type = #{entityType} order by id desc"})
    List<Comment> selectByEntity(@Param("entityId") int entityId, @Param("entityType") int entityType);

    @Select({"select count(id) from ", TABLE_NAME, " where entity_id = #{entityId} and entity_type = #{entityType}"})
    int getCommentCount(@Param("entityId") int entityId, @Param("entityType") int entityType);

    @Select({"select count(id) from ", TABLE_NAME, " where user_id = #{userId}"})
    int getUserCommentCount(@Param("userId") int userId);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id = #{id}"})
    Comment selectById(@Param("id") int id);


}
