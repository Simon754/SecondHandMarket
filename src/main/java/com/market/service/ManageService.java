package com.market.service;

import com.market.model.Item;
import org.springframework.stereotype.Service;

@Service
public interface ManageService {
    boolean deleteItem(Item item);
    boolean passItem(Item item);
}
