package com.xhl.shardingmaildataimport.util;

public class MailBoxUtil {

    public static volatile int bathId = -1;

    public static synchronized int getbathId() {
        bathId++;
        return bathId;
    }
}
