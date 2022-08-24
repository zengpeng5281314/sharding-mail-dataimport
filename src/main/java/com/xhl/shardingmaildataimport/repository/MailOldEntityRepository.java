package com.xhl.shardingmaildataimport.repository;

import com.xhl.shardingmaildataimport.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailOldEntityRepository extends JpaRepository<Mail, Long>, JpaSpecificationExecutor<Mail>{


    @Query(value = "select * from mail_box where id >= (select id from mail_box order by id asc limit :startId ,1) limit :size",nativeQuery = true)
    List<Mail> getMailList(@Param("startId") Long  startId ,@Param("size") int size);


}
