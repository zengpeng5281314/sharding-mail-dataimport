package com.xhl.shardingmaildataimport.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhl.shardingmaildataimport.threads.MailBoxTestRunnal;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;

@RestController
@Slf4j
@RequestMapping("/mailbox")
public class MailboxController {


    @Autowired
    ThreadPoolExecutor threadPoolExecutor;

    @PostMapping("/import")
    public String importMailBox(HttpServletRequest request) {
//        MailBoxTestRunnal mailBoxTestRunnalA = new MailBoxTestRunnal("线程A ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalB = new MailBoxTestRunnal("线程B ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalC = new MailBoxTestRunnal("线程C ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalD = new MailBoxTestRunnal("线程D ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalE = new MailBoxTestRunnal("线程E ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalF = new MailBoxTestRunnal("线程F ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalG = new MailBoxTestRunnal("线程G ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalH = new MailBoxTestRunnal("线程H ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalJ = new MailBoxTestRunnal("线程I ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalK = new MailBoxTestRunnal("线程K ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalA1 = new MailBoxTestRunnal("线程A1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalB1 = new MailBoxTestRunnal("线程B1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalC1 = new MailBoxTestRunnal("线程C1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalD1 = new MailBoxTestRunnal("线程D1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalE1 = new MailBoxTestRunnal("线程E1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalF1 = new MailBoxTestRunnal("线程F1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalG1 = new MailBoxTestRunnal("线程G1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalH1 = new MailBoxTestRunnal("线程H1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalJ1 = new MailBoxTestRunnal("线程I1 ",new JSONArray());
//        MailBoxTestRunnal mailBoxTestRunnalK1 = new MailBoxTestRunnal("线程K1 ",new JSONArray());
//        threadPoolExecutor.execute(mailBoxTestRunnalA);
//        threadPoolExecutor.execute(mailBoxTestRunnalB);
//        threadPoolExecutor.execute(mailBoxTestRunnalC);
//        threadPoolExecutor.execute(mailBoxTestRunnalD);
//        threadPoolExecutor.execute(mailBoxTestRunnalE);
//        threadPoolExecutor.execute(mailBoxTestRunnalF);
//        threadPoolExecutor.execute(mailBoxTestRunnalG);
//        threadPoolExecutor.execute(mailBoxTestRunnalH);
//        threadPoolExecutor.execute(mailBoxTestRunnalJ);
//        threadPoolExecutor.execute(mailBoxTestRunnalK);
//        threadPoolExecutor.execute(mailBoxTestRunnalA1);
//        threadPoolExecutor.execute(mailBoxTestRunnalB1);
//        threadPoolExecutor.execute(mailBoxTestRunnalC1);
//        threadPoolExecutor.execute(mailBoxTestRunnalD1);
//        threadPoolExecutor.execute(mailBoxTestRunnalE1);
//        threadPoolExecutor.execute(mailBoxTestRunnalF1);
//        threadPoolExecutor.execute(mailBoxTestRunnalG1);
//        threadPoolExecutor.execute(mailBoxTestRunnalH1);
//        threadPoolExecutor.execute(mailBoxTestRunnalJ1);
//        threadPoolExecutor.execute(mailBoxTestRunnalK1);

        for (int i = 1; i < 5; i++) {
            String name = String.valueOf(i);
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程A " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程B " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程C " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程D " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程E " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程F " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程G " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程H " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程I " + name, new JSONArray()));
            threadPoolExecutor.execute(new MailBoxTestRunnal("线程K " + name, new JSONArray()));
        }

        return "导入开始";
    }

}
