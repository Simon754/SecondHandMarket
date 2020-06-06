package com.market.dao;

import com.market.model.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Item record);

    List<Item> selectItemsByUserID(int userID);

    List<Item> selectOnline();

    List<Item> selectAll();

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}