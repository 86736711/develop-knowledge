package com.npf.knowledge.redission;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.redission
 * @ClassName: RedissionTest
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/9 14:38
 * @Version: 1.0
 */
public class RedissionTest {

    private static final String LOCK_KEY_ROOT = "lock:";
    public static final String LOCK_KEY = LOCK_KEY_ROOT+"lock_test";

    public static Integer integer = new Integer(0);


    public static void main(String[] args) {


        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.12.237:16379");
        config.useSingleServer().setPassword("foobared123");
        config.useSingleServer().setDatabase(4);
        RedissonClient redissonClient = Redisson.create(config);

        RBucket<Object> bucket = redissonClient.getBucket("test:123456");
        //PSETEX
        bucket.set(true,30, TimeUnit.SECONDS);


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            executorService.submit(new RunNumber(redissonClient));
        }
        //redissonClient.shutdown();

        System.out.println("system test end!");

    }


}
