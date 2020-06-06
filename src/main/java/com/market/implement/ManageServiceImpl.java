package com.market.implement;

import com.market.dao.ItemMapper;
import com.market.model.Item;
import com.market.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "manageService")

public class ManageServiceImpl implements ManageService {
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public boolean deleteItem(Item item) {
        return itemMapper.deleteByPrimaryKey(item.getItemid())!=0;
    }

    @Override
    public boolean passItem(Item item) {
        return itemMapper.updateByPrimaryKeySelective(item)!=0;
    }
}
