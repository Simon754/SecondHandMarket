package com.market.dao;

import com.market.model.Record;
import com.market.model.User;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordid);

    int insert(Record record);

    List<Record> selectByUser(User user);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}