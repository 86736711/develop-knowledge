package com.npf.knowledge.redission;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.redission
 * @ClassName: RunNumber
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/9 15:49
 * @Version: 1.0
 */
public class RunNumber implements Runnable {

    private RedissonClient redissonClient;


    public RunNumber(RedissonClient redissonClient){
        this.redissonClient = redissonClient;
    }

    public void run() {
        RLock lock = redissonClient.getLock(RedissionTest.LOCK_KEY);
        lock.lock(10, TimeUnit.SECONDS);
        RedissionTest.integer = RedissionTest.integer + 1;
        System.out.println("number--------->"+RedissionTest.integer );
        lock.unlock();
    }
}
