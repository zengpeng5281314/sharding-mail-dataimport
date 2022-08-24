package com.xhl.shardingmaildataimport.service.impl;

import com.xhl.shardingmaildataimport.entity.Mail;
import com.xhl.shardingmaildataimport.entity.MailFowardArchiveStatuEntity;
import com.xhl.shardingmaildataimport.entity.MailNewEntity;
import com.xhl.shardingmaildataimport.repository.MailFowardArchiveStatuEntityRespository;
import com.xhl.shardingmaildataimport.repository.MailNewEntityRepository;
import com.xhl.shardingmaildataimport.repository.MailOldEntityRepository;
import com.xhl.shardingmaildataimport.service.MailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxServiceImpl implements MailBoxService {

    @Autowired
    MailNewEntityRepository mailNewEntityRepository;
    @Autowired
    MailOldEntityRepository mailOldEntityRepository;
    @Autowired
    MailFowardArchiveStatuEntityRespository mailFowardArchiveStatuEntityRespository;

    @Override
    public MailNewEntity selectById(Integer orgId, Integer userId, Long id) {
        MailNewEntity mailNewEntity = new MailNewEntity();
        mailNewEntity.setOrgId(orgId);
        mailNewEntity.setUserId(userId);
        mailNewEntity.setId(id);
        Example<MailNewEntity> example = Example.of(mailNewEntity);
        List<MailNewEntity> list = mailNewEntityRepository.findAll(example);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    @Override
    public List<Mail> getMailList(Long startId, int size) {
        return mailOldEntityRepository.getMailList(startId, size);
    }

    @Override
    public void saveMailNewEntities(List<MailNewEntity> list) {
        mailNewEntityRepository.saveAll(list);
    }

    @Override
    public void saveMailNewEntityBySql(MailNewEntity mailNewEntity) {
        mailNewEntityRepository.saveBySql(mailNewEntity.getId(), mailNewEntity.getMailSubject(), mailNewEntity.getMailFrom(), mailNewEntity.getMailSendDate(), mailNewEntity.getMailTo(), mailNewEntity.getRecipientsCc(), mailNewEntity.getRecipientsBcc(),
                mailNewEntity.getReplyTo(), mailNewEntity.getOriginalMailBoxTypeId(), mailNewEntity.getMailBoxTypeId(), mailNewEntity.getMailUrgentFlag(), mailNewEntity.getMailReceiptFlag(), mailNewEntity.getMailAttachmentFlag(),
                mailNewEntity.getMailCrmFlag(), mailNewEntity.getMailPlainTextFlag(), mailNewEntity.getMailReadFlag(), mailNewEntity.getMailSuccessFlag(), mailNewEntity.getMailSendErrorMsg(), mailNewEntity.getOrgId(), mailNewEntity.getUserId(),
                mailNewEntity.getAccountId(), mailNewEntity.getCreateUserId(), mailNewEntity.getCreateUserName(), mailNewEntity.getCreateTime(), mailNewEntity.getUpdateUserId(), mailNewEntity.getUpdateUserName(), mailNewEntity.getUpdateTime(),
                mailNewEntity.getMailDeleteFlag(), mailNewEntity.getCheckTime(), mailNewEntity.getMailTraceFlag(), mailNewEntity.getMailSize(), mailNewEntity.getMailSignId(), mailNewEntity.getMailServerType(), mailNewEntity.getCustomerId(),
                mailNewEntity.getRecentOpenTime(), mailNewEntity.getRecentOpenPosition(), mailNewEntity.getMailOpenTimes(), mailNewEntity.getRecentOpenIp(), mailNewEntity.getFromOrToFlag(), mailNewEntity.getMailDraftFlag(),
                mailNewEntity.getTraceTimeStamp(), mailNewEntity.getMailEmlPath(), mailNewEntity.getRecieverCrmFlag(), mailNewEntity.getCustomerEnterpriseIds(), mailNewEntity.getMailId(), mailNewEntity.getMailContentQiniuFlag(),
                mailNewEntity.getMailContentQiniuAddress(), mailNewEntity.getMailMyclueFlag(), mailNewEntity.getRecieverMyclueFlag(), mailNewEntity.getMailStarFlag(), mailNewEntity.getMailTimeFlag(), mailNewEntity.getMailRepeatedFlag(),
                mailNewEntity.getMailAnsweredFlag(), mailNewEntity.getOriginalMailId(), mailNewEntity.getMailFolderName(), mailNewEntity.getMailGroupSendingSingleShowFlag(), mailNewEntity.getMailLeadscloudUuid(), mailNewEntity.getMailToDoFlag(),
                mailNewEntity.getMailToDoTime(), mailNewEntity.getMailToDoUserId(), mailNewEntity.getMailInterForwardingFlag(), mailNewEntity.getMailForwardedInternallyFlag(), mailNewEntity.getOppositeAnsweredFlag(), mailNewEntity.getForwardFlag(),
                mailNewEntity.getArchiveFlag(), mailNewEntity.getMessageId(), mailNewEntity.getXMicrosoftOriginalMessageId());

    }

    @Override
    public MailFowardArchiveStatuEntity getMailFowardArchiveStatuEntity(String mailId) {
        return  mailFowardArchiveStatuEntityRespository.findById(mailId).orElse(null);
    }


}
