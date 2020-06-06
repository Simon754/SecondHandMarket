package com.market.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * @author Simon
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResult {
    private int code;
    private String message;
    private List<Item> list;
    private Object object;
    private List<Record> records;
}
