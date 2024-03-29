package com.simulationlab.QA_2.dao;

import com.simulationlab.QA_2.model.Feed;
import com.simulationlab.QA_2.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FeedDAO {
    String TABLE_NAME = "feed";
    String INSERT_FIELDS = "created_date, user_id, data, type";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values(#{createdDate}, #{userId}, #{data}, #{type})"})
    int addFeed(Feed feed);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id = #{id}"})
    Feed selectById(@Param("id") int id);

    // 获取用户所有的feed
    List<Feed> selectUserFeeds(@Param("maxId") int maxId,
                               @Param("userIds") List<Integer> userIds,
                               @Param("count") int count);
}
