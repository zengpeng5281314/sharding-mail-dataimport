package com.xhl.shardingmaildataimport.repository;

import com.xhl.shardingmaildataimport.entity.MailFowardArchiveStatuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MailFowardArchiveStatuEntityRespository extends JpaRepository<MailFowardArchiveStatuEntity, String>, JpaSpecificationExecutor<MailFowardArchiveStatuEntity> {
}
