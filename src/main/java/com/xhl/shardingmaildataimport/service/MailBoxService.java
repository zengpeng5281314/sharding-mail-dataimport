package com.xhl.shardingmaildataimport.service;

import com.xhl.shardingmaildataimport.entity.Mail;
import com.xhl.shardingmaildataimport.entity.MailFowardArchiveStatuEntity;
import com.xhl.shardingmaildataimport.entity.MailNewEntity;

import java.util.List;

public interface MailBoxService {

    MailNewEntity selectById(Integer orgId, Integer userId, Long id);

    List<Mail> getMailList(Long startId, int size);

    void saveMailNewEntities(List<MailNewEntity> list);

    void saveMailNewEntityBySql(MailNewEntity mailNewEntity);

    MailFowardArchiveStatuEntity getMailFowardArchiveStatuEntity(String mailId);
}
