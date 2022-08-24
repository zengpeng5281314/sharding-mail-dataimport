package com.xhl.shardingmaildataimport.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "mail_box_new")
public class MailNewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	//手动赋值id
//	@GeneratedValue(generator = "id")
//	@GenericGenerator(name = "id", strategy = "assigned")
	private Long id;
	@Column
	private String mailSubject;
	@Column
	private String mailFrom;
	@Column
	private String mailSendDate;
	@Column
	private String mailTo;
	@Column
	private String recipientsCc;//抄送人
	@Column
	private String recipientsBcc;//密送人
	@Column
	//("表示回复地址，由发件方编辑，希望收件人回复邮件时回复到指定的地址")
	private String replyTo;
	@Column
	private Integer mailBoxTypeId;//0-未读箱、0-收件箱、5-草稿箱、4-已发箱、2-垃圾箱、6-归并箱、3-已删除箱
	@Column
	private String accountId;
	@Column
	private String mailUrgentFlag;//紧急标志@0不紧急1标识紧急默认0
	@Column
	private int mailPlainTextFlag; //邮件内容是否是纯文本  1是 0否  默认是0
	@Column
	private String mailReceiptFlag;//邮件回执标志@0不需要回执1需要回执默认0
	@Column
	private String mailAttachmentFlag;//是否有附件@1表示有附件0表示没有附件默认0没有
	@Column
	private String mailReadFlag;//已读标志@0标识未读1标识已读默认0未读
	@Column
	private String mailStarFlag;
	@Column
	private String mailTraceFlag;//邮件是否被追踪
	@Column
	private Integer mailCrmFlag;//是否在系统中@0标志不在1表示在TODO
	@Column
	private String mailMyclueFlag;//发件人是否在我的线索中
	@Column
	private Integer mailSuccessFlag;//是否发送成功标志@0不成功1表示成功
	@Column
	private String createUserId;
	@Column
	private String createUserName;
	@Column
	private String createTime;
	@Column
	private String updateUserId;
	@Column
	private String updateUserName;
	@Column
	private String updateTime;
	@Column
	private String recentOpenTime;
	@Column
	private String recentOpenPosition;
	@Column
	private Integer mailOpenTimes;
	@Column
	private String recentOpenIp;
	@Column
	private String mailSize;
	@Column
	private String mailDeleteFlag;
	@Column
	private Integer recieverCrmFlag;//收件人是否在crm系统中存在.无论有几个收件人,只要有一个人在crm中,则该值为1,否则为0
	@Column
	private Integer recieverMyclueFlag;//收件人是否在我的线索中.无论有几个收件人,只要有一个人在我的线索里,则该值为1,否则为0
	@Column
	private Integer fromOrToFlag;//是发件 还是收件  1发件   其他情况为收件
	@Column
	private Integer originalMailBoxTypeId;
	@Column
	private String customerEnterpriseIds;
	@Column
	private String mailId;//用户邮件的唯一标识 由“userId,邮件独有的uid组成”
	@Column
	private String mailContentQiniuFlag; //默认值为0表示不在七牛，1表示在七牛
	@Column
	private String mailContentQiniuAddress;
	@Column
	private Integer mailDraftFlag;//是否在草稿箱   1是，0否
	@Column
	private Integer mailTimeFlag;//是否为定时邮件
	@Column
	private Integer mailAnsweredFlag;//是否被回复  1是  0否
	@Column
	private String mailServerType;//邮件服务器类型
	@Column
	private String mailFolderName;//邮件在自身服务器中所属的箱体：例如已发箱，INBOX
	@Column
	private Integer mailRepeatedFlag;//邮件是否重复标识    0不重复  1重复
	@Column
	private Integer mailGroupSendingSingleShowFlag;
	@Column
	private String mailSendErrorMsg;//邮件发送失败的报错原因
	//邮件是否处理了的标识：0未设置，1待处理，2已完成。已发箱邮件默认是0，收件箱邮件默认是1
	@Column
	private Integer mailToDoFlag;
	//邮件的处理人
	@Column
	private Integer mailToDoUserId;
	//邮件的处理时间
	@Column
	private Date mailToDoTime;
	//邮件是否是内部转发过来的邮件 1是，0否；默认是0
	@Column
	private Integer mailInterForwardingFlag;
	//邮件是否是被内部转发 1是，0否；默认是0
	@Column
	private Integer mailForwardedInternallyFlag;
	//（对方已回复标识 0：未回复 1：已回复 2：失败）
	@Column
	private int oppositeAnsweredFlag;
	//（转发标识 0：未转发 1：已转发 2：失败）
	@Column
	private int forwardFlag;
	//（归档标识 0：未归档 1：已归档 2：失败）
	@Column
	private int archiveFlag;
	@Column
	private Integer orgId;
	//用户id
	@Column
	private Integer userId;
	// 邮件的messageId
	@Column
	private String messageId;
	//（邮箱服务商变更的messageId）
	@Column
	private String xMicrosoftOriginalMessageId;

	@Column
	private Date checkTime;
	@Column
	private Integer mailSignId;
	@Column
	private String customerId;
	@Column
	private String traceTimeStamp;
	@Column
	private String mailEmlPath;
	@Column
	private String mailLeadscloudUuid;
	@Column
	private Integer originalMailId;
}
