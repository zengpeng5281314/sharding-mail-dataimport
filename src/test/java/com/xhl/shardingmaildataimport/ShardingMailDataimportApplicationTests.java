package com.xhl.shardingmaildataimport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhl.shardingmaildataimport.entity.Mail;
import com.xhl.shardingmaildataimport.entity.MailNewEntity;
import com.xhl.shardingmaildataimport.repository.MailNewEntityRepository;
import com.xhl.shardingmaildataimport.repository.MailOldEntityRepository;
import com.xhl.shardingmaildataimport.service.MailBoxService;
import com.xhl.shardingmaildataimport.threads.MailBoxTestRunnal;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShardingMailDataimportApplicationTests {

    @Autowired
    private MailNewEntityRepository mailNewEntityRepository;

    @Autowired
    private MailBoxService mailBoxService;
    @Autowired
    MailOldEntityRepository mailOldEntityRepository;

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;

    @Test
    void contextLoads() {
//        mailNewEntityRepository.findById(1L);
        System.out.println("------" + JSONObject.toJSONString(mailBoxService.selectById(10110, 5770, 2L)));
    }

    @Test
    void getOldMail() {
        List<Mail> list = mailOldEntityRepository.getMailList((long) (1 * 10), 10);
        list.forEach(System.out::println);
    }

    @Test
    void saveMailNewEntity() {

        List<Mail> list = mailBoxService.getMailList(0L, 1);
        List<MailNewEntity> mailNewEntityList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            //TODO 处理数据
            for (int i = 0; i < list.size(); i++) {
                Mail mail = list.get(i);
                MailNewEntity mailNewEntity = JSONObject.parseObject(JSONObject.toJSONString(mail), MailNewEntity.class);
                mailNewEntity.setUserId(Integer.parseInt(mail.getCreateUserId()));
                mailNewEntity.setOrgId(Integer.parseInt(mail.getEnterpriseId()));
                mailNewEntity.setId(mail.getId());
                System.out.println(JSONObject.toJSONString(mailNewEntity));
                mailBoxService.saveMailNewEntityBySql(mailNewEntity);
//                mailNewEntityList.add(mailNewEntity);
            }
            //保存
//            mailBoxService.saveMailNewEntities(mailNewEntityList);
        } else {
        }
    }

    @Test
    void testThreads() throws IOException {
        MailBoxTestRunnal mailBoxTestRunnalA = new MailBoxTestRunnal("线程A ", new JSONArray());
        MailBoxTestRunnal mailBoxTestRunnalB = new MailBoxTestRunnal("线程B ", new JSONArray());
        MailBoxTestRunnal mailBoxTestRunnalC = new MailBoxTestRunnal("线程C ", new JSONArray());
        MailBoxTestRunnal mailBoxTestRunnalD = new MailBoxTestRunnal("线程D ", new JSONArray());
        MailBoxTestRunnal mailBoxTestRunnalE = new MailBoxTestRunnal("线程E ", new JSONArray());
        threadPoolExecutor.execute(mailBoxTestRunnalA);
        threadPoolExecutor.execute(mailBoxTestRunnalB);
        threadPoolExecutor.execute(mailBoxTestRunnalC);
        threadPoolExecutor.execute(mailBoxTestRunnalD);
        threadPoolExecutor.execute(mailBoxTestRunnalE);
        System.in.read();
    }

    @Test
    void getMailFowardArchiveStatuEntityById() {
        System.out.println("-----"+JSONObject.toJSONString(mailBoxService.getMailFowardArchiveStatuEntity("111")));
        System.out.println("-----"+JSONObject.toJSONString(mailBoxService.getMailFowardArchiveStatuEntity("12161844")));
    }


    public static void main(String[] args) {
        Mail mailoldEntity = new Mail();
        mailoldEntity.setId(1212L);
        mailoldEntity.setEnterpriseId("24");
//        mailoldEntity.setUserId(231);
        MailNewEntity mailNewEntity = new MailNewEntity();
        BeanUtils.copyProperties(mailoldEntity, mailNewEntity);

        MailNewEntity mailNewEntity2 = JSONObject.parseObject(JSONObject.toJSONString(mailoldEntity), MailNewEntity.class);
        System.out.println(JSONObject.toJSONString(mailoldEntity));
        System.out.println(JSONObject.toJSONString(mailNewEntity));
        System.out.println(JSONObject.toJSONString(mailNewEntity2));
    }

}
