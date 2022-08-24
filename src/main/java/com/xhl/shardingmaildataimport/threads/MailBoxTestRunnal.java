package com.xhl.shardingmaildataimport.threads;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhl.shardingmaildataimport.conf.SpringContextUtil;
import com.xhl.shardingmaildataimport.entity.Mail;
import com.xhl.shardingmaildataimport.entity.MailFowardArchiveStatuEntity;
import com.xhl.shardingmaildataimport.entity.MailNewEntity;
import com.xhl.shardingmaildataimport.service.MailBoxService;
import com.xhl.shardingmaildataimport.util.MailBoxUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailBoxTestRunnal implements Runnable {

    private String threadName;
    private JSONArray data;

    private MailBoxService mailBoxService = SpringContextUtil.getBean(MailBoxService.class);

    public MailBoxTestRunnal(String threadName, JSONArray data) {
        this.threadName = threadName;
        this.data = data;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            int bathId = MailBoxUtil.getbathId();
            Long startID = Long.parseLong(String.valueOf(bathId * 3000));
            List<Mail> list = mailBoxService.getMailList(startID, 3000);
            List<MailNewEntity> mailNewEntityList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                log.info("-------" + threadName + " 开始处理 mailbox_box 批次 " + bathId + "  的数据 数据大小：" + list.size());
                //TODO 处理数据
                for (int i = 0; i < list.size(); i++) {
                    try {
                        Mail mail = list.get(i);
                        MailNewEntity mailNewEntity = JSONObject.parseObject(JSONObject.toJSONString(mail), MailNewEntity.class);
                        mailNewEntity.setUserId(Integer.parseInt(mail.getCreateUserId()));
                        mailNewEntity.setOrgId(Integer.parseInt(mail.getEnterpriseId()));
                        mailNewEntity.setId(mail.getId());
//                    System.out.println(JSONObject.toJSONString(mailNewEntity));
                        MailFowardArchiveStatuEntity mailFowardArchiveStatuEntity = mailBoxService.getMailFowardArchiveStatuEntity(mail.getId().toString());
                        if (mailFowardArchiveStatuEntity != null) {
                            mailNewEntity.setOppositeAnsweredFlag(mailFowardArchiveStatuEntity.getOppositeAnsweredFlag());
                            mailNewEntity.setForwardFlag(mailFowardArchiveStatuEntity.getForwardFlag());
                            mailNewEntity.setArchiveFlag(mailFowardArchiveStatuEntity.getArchiveFlag());
                            mailNewEntity.setMessageId(mailFowardArchiveStatuEntity.getMessageId());
                            mailNewEntity.setXMicrosoftOriginalMessageId(mailFowardArchiveStatuEntity.getXMicrosoftOriginalMessageId());
                        }
                        mailBoxService.saveMailNewEntityBySql(mailNewEntity);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
//                   mailNewEntityList.add(mailNewEntity);
                }
                //保存
//                mailBoxService.saveMailNewEntities(mailNewEntityList);
                log.info("-------" + threadName + " 完成处理 mailbox_box 批次 " + bathId + "  的数据");
            } else {
                break;
            }
        }
        System.out.println("-------" + threadName + " 处理完成！");
    }

    private MailNewEntity copyMM(Mail mail, MailNewEntity mailNewEntity) {

        MailNewEntity mailNewEntity2 = JSONObject.parseObject(JSONObject.toJSONString(mail), MailNewEntity.class);


        return mailNewEntity;
    }

}
