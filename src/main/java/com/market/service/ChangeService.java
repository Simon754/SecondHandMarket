package com.market.service;

import com.market.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Simon
 */
@Service
public interface ChangeService {
    boolean addItem(Item item);
    boolean updateUser(User user);
    boolean buy(Param param);
    List<Record> getRecord(User user);
    boolean makeComment(Comment comment);
}
