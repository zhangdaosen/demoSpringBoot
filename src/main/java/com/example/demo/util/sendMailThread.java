package com.example.demo.util;

import javax.mail.MessagingException;
import java.util.concurrent.CyclicBarrier;

public class sendMailThread implements Runnable{
    CyclicBarrier barrier;

    public  sendMailThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            barrier.await();
            System.out.println(System.currentTimeMillis());
            SendMail.sendMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
