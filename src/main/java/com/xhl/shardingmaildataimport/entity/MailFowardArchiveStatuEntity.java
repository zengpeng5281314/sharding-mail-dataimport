package com.xhl.shardingmaildataimport.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author tangfupin
 * @description 邮件-对方已回复-已转发-归档状态关系表
 * @date 2022-07-08 16:36
 */
@Data
@Entity
@Table(name = "mail_foward_archive_statu")
public class MailFowardArchiveStatuEntity {

    @Id
    private String mailId;
    @Column
    private Integer orgId;

    /**对方已回复标识 0：未回复 1：已回复 2：失败*/
    @Column
    private Integer oppositeAnsweredFlag;
    /**转发标识 0：未转发 1：已转发 2：失败*/
    @Column
    private Integer forwardFlag;
    /**归档标识 0：未归档 1：已归档 2：失败*/
    @Column
    private Integer archiveFlag;
    /**邮件的消息ID*/
    @Column
    private String messageId;
    /**邮件的消息ID加密值*/
    @Column
    private String msIdEncryption;
    /**是在发件箱还是在收件箱  1发件箱,2同步过来的已发箱，其它是收件箱*/
    @Column
    private Integer fromOrToFlag;
    /**目前发现从询盘云通过outlook发时，它会修改Message-ID为它自己的，而询盘云的被设置为字段：X-Microsoft-Original-Message-ID*/
    @Column
    private String xMicrosoftOriginalMessageId;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

}
