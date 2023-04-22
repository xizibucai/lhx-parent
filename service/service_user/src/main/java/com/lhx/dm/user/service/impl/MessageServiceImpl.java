package com.lhx.dm.user.service.impl;


import com.lhx.dm.user.mapper.MessageDao;
import com.lhx.dm.user.entity.Message;
import com.lhx.dm.user.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DELL
 * @date 2020/5/20 21:22
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Override
    public void saveMessage(Message message) {
        messageDao.saveMessage(message);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }
}
