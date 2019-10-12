package com.wzy.common.respones;

import lombok.Data;

import java.util.List;

@Data
public class MessageBody<T> {
    Integer code;
    String message;
    T data;
    List<T> datas;
    Integer pageSize;
    Integer pageNo;
    Integer datasCount;
}
