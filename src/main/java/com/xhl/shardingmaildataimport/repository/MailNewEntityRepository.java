package com.xhl.shardingmaildataimport.repository;

import com.xhl.shardingmaildataimport.entity.MailNewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface MailNewEntityRepository extends JpaRepository<MailNewEntity, Long>, JpaSpecificationExecutor<MailNewEntity> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO mail_box_new (id,mail_subject,mail_from,mail_send_date,mail_to,recipients_cc,recipients_bcc,reply_to,original_mail_box_type_id,mail_box_type_id,mail_urgent_flag,mail_receipt_flag,mail_attachment_flag,mail_crm_flag,mail_plain_text_flag,mail_read_flag,mail_success_flag,mail_send_error_msg,org_id,user_id,account_id,create_user_id,create_user_name,create_time,update_user_id,update_user_name,update_time,mail_delete_flag,check_time,mail_trace_flag,mail_size,mail_sign_id,mail_server_type,customer_id,recent_open_time,recent_open_position,mail_open_times,recent_open_ip,from_or_to_flag,mail_draft_flag,trace_time_stamp,mail_eml_path,reciever_crm_flag,customer_enterprise_ids,mail_id,mail_content_qiniu_flag,mail_content_qiniu_address,mail_myclue_flag,reciever_myclue_flag,mail_star_flag,mail_time_flag,mail_repeated_flag,mail_answered_flag,original_mail_id,mail_folder_name,mail_group_sending_single_show_flag,mail_leadscloud_uuid,mail_to_do_flag,mail_to_do_time,mail_to_do_user_id,mail_inter_forwarding_flag,mail_forwarded_internally_flag,opposite_answered_flag,forward_flag,archive_flag,message_id,x_microsoft_original_message_id) VALUES" +
            "( :id, :mailSubject, :mailFrom, :mailSendDate, :mailTo, :recipientsCc, :recipientsBcc, :replyTo, :originalMailBoxTypeId," +
            " :mailBoxTypeId, :mailUrgentFlag, :mailReceiptFlag, :mailAttachmentFlag, :mailCrmFlag, :mailPlainTextFlag, :mailReadFlag, :mailSuccessFlag," +
            " :mailSendErrorMsg, :orgId, :userId, :accountId, :createUserId, :createUserName, :createTime, :updateUserId, :updateUserName, :updateTime," +
            " :mailDeleteFlag, :checkTime, :mailTraceFlag, :mailSize, :mailSignId, :mailServerType, :customerId, :recentOpenTime, " +
            " :recentOpenPosition, :mailOpenTimes, :recentOpenIp, :fromOrToFlag, :mailDraftFlag, :traceTimeStamp, :mailEmlPath, " +
            " :recieverCrmFlag, :customerEnterpriseIds, :mailId, :mailContentQiniuFlag, :mailContentQiniuAddress, :mailMyclueFlag, " +
            " :recieverMyclueFlag, :mailStarFlag, :mailTimeFlag, :mailRepeatedFlag, :mailAnsweredFlag, :originalMailId, :mailFolderName, " +
            " :mailGroupSendingSingleShowFlag, :mailLeadscloudUuid, :mailToDoFlag, :mailToDoTime, :mailToDoUserId," +
            " :mailInterForwardingFlag, :mailForwardedInternallyFlag, :oppositeAnsweredFlag, :forwardFlag, :archiveFlag, " +
            " :messageId, :xMicrosoftOriginalMessageId) ", nativeQuery = true)
    void saveBySql(@Param(value = "id")Long id, @Param(value = "mailSubject") String mailSubject, @Param(value = "mailFrom")String mailFrom, @Param(value = "mailSendDate") String mailSendDate,
                   @Param(value = "mailTo")String mailTo, @Param(value = "recipientsCc")String recipientsCc, @Param(value = "recipientsBcc")String recipientsBcc,
                   @Param(value = "replyTo")String replyTo, @Param(value = "originalMailBoxTypeId")Integer originalMailBoxTypeId, @Param(value = "mailBoxTypeId")Integer mailBoxTypeId,
                   @Param(value = "mailUrgentFlag")String mailUrgentFlag, @Param(value = "mailReceiptFlag")String mailReceiptFlag, @Param(value = "mailAttachmentFlag")String mailAttachmentFlag,
                   @Param(value = "mailCrmFlag")Integer mailCrmFlag, @Param(value = "mailPlainTextFlag")int mailPlainTextFlag, @Param(value = "mailReadFlag")String mailReadFlag,
                   @Param(value = "mailSuccessFlag")Integer mailSuccessFlag, @Param(value = "mailSendErrorMsg")String mailSendErrorMsg, @Param(value = "orgId")Integer orgId, @Param(value = "userId")Integer userId,
                   @Param(value = "accountId")String accountId, @Param(value = "createUserId")String createUserId, @Param(value = "createUserName")String createUserName, @Param(value = "createTime")String createTime,
                   @Param(value = "updateUserId")String updateUserId, @Param(value = "updateUserName")String updateUserName, @Param(value = "updateTime")String updateTime,
                   @Param(value = "mailDeleteFlag")String mailDeleteFlag, @Param(value = "checkTime") Date checkTime, @Param(value = "mailTraceFlag")String mailTraceFlag, @Param(value = "mailSize")String mailSize,
                   @Param(value = "mailSignId")Integer mailSignId, @Param(value = "mailServerType")String mailServerType, @Param(value = "customerId")String customerId, @Param(value = "recentOpenTime")String recentOpenTime,
                   @Param(value = "recentOpenPosition")String recentOpenPosition,@Param(value = "mailOpenTimes")Integer mailOpenTimes,@Param(value = "recentOpenIp")String recentOpenIp,
                   @Param(value = "fromOrToFlag")Integer fromOrToFlag,@Param(value = "mailDraftFlag")Integer mailDraftFlag,@Param(value = "traceTimeStamp")String traceTimeStamp,
                   @Param(value = "mailEmlPath")String mailEmlPath,@Param(value = "recieverCrmFlag")Integer recieverCrmFlag,
                   @Param(value = "customerEnterpriseIds")String customerEnterpriseIds,@Param(value = "mailId")String mailId,@Param(value = "mailContentQiniuFlag")String mailContentQiniuFlag,
                   @Param(value = "mailContentQiniuAddress")String mailContentQiniuAddress,@Param(value = "mailMyclueFlag")String mailMyclueFlag,@Param(value = "recieverMyclueFlag")Integer recieverMyclueFlag,
                   @Param(value = "mailStarFlag")String mailStarFlag,@Param(value = "mailTimeFlag")Integer mailTimeFlag,@Param(value = "mailRepeatedFlag")Integer mailRepeatedFlag,
                   @Param(value = "mailAnsweredFlag")Integer mailAnsweredFlag,@Param(value = "originalMailId")Integer originalMailId,@Param(value = "mailFolderName")String mailFolderName,
                   @Param(value = "mailGroupSendingSingleShowFlag")Integer mailGroupSendingSingleShowFlag,@Param(value = "mailLeadscloudUuid")String mailLeadscloudUuid,@Param(value = "mailToDoFlag")Integer mailToDoFlag,
                   @Param(value = "mailToDoTime")Date mailToDoTime,@Param(value = "mailToDoUserId")Integer mailToDoUserId,
                   @Param(value = "mailInterForwardingFlag")Integer mailInterForwardingFlag,@Param(value = "mailForwardedInternallyFlag")Integer mailForwardedInternallyFlag,@Param(value = "oppositeAnsweredFlag")int oppositeAnsweredFlag,
                   @Param(value = "forwardFlag")int forwardFlag,@Param(value = "archiveFlag")int archiveFlag,@Param(value = "messageId")String messageId,
                   @Param(value = "xMicrosoftOriginalMessageId")String xMicrosoftOriginalMessageId
                   );

}
