package com.xhl.shardingmaildataimport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShardingMailDataimportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingMailDataimportApplication.class, args);
    }

    @GetMapping("status/health")
    public int healthcheck() {
        return 1;
    }
}
