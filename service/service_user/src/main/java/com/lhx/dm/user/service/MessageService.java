package com.lhx.dm.user.service;



import com.lhx.dm.user.entity.Message;

import java.util.List;

public interface MessageService {

    void saveMessage(Message message);

    List<Message> findAll();

}
