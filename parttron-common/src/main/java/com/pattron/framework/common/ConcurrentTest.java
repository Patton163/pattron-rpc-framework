package com.pattron.framework.common;

import thread.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 并发测试包
 *
 * @Author: huyibo
 * @Date: 2021/6/6
 */
public class ConcurrentTest {


    public static void main(String[] args) {
        List<Future<String>> futureList = new ArrayList<>();
        int culTime = 0;
        while (culTime < 100) {
            for (int i = 0; i < 4; i++) {
                try {
//                    Thread.sleep(100);
//                    System.out.println("do some thins ....");
                    futureList.add(ThreadPoolManager.sub(new TaskWorker(ThreadPoolManager.getExecutor())));
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

            }

            for (Future<String> future : futureList) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            culTime++;
        }

    }

}
