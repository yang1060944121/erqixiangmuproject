package com.aaa.config;

import com.aaa.properties.RedisClusterproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisClusterConfig {

   @Autowired
   private RedisClusterproperties redisClusterproperties;

    @Bean
    public JedisCluster getJedisCluster() {
        String nodes = redisClusterproperties.getNodes();
        String[] split = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for(String hostPort : split) {
            String[] split1 = hostPort.split(":");// 0:ip 1:port
            HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.parseInt(split1[1]));
            hostAndPortSet.add(hostAndPort);
        }
        return new JedisCluster(hostAndPortSet, redisClusterproperties.getCommandTimeout(), redisClusterproperties.getMaxAttempts());
    }

}
