package com.pattron.framework.common;

import com.sun.javafx.binding.StringFormatter;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: huyibo
 * @Date: 2021/6/6
 */
public class TaskWorker implements Callable<String> {

    private ThreadPoolExecutor poolExecutor;

    public TaskWorker() {
    }

    public TaskWorker(ThreadPoolExecutor poolExecutor) {
        this.poolExecutor = poolExecutor;
    }

    @Override
    public String call() throws Exception {
        double sleepTime = Math.random() * 1000;
        Thread.sleep((int) sleepTime);
        int activeCount = poolExecutor.getActiveCount();
        long taskCount = poolExecutor.getTaskCount();
        int poolSize = poolExecutor.getPoolSize();
        System.out.println(StringFormatter.concat( Thread.currentThread().getName(),
                "... the activeCount is ", activeCount, "... the poolSize is ", poolSize
        ).getValue());
        return null;
    }
}
