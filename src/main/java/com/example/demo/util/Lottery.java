package com.example.demo.util;

import java.util.Random;

public class Lottery {

    public static void shuangseqiu(){
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            System.out.println("红：" + (r.nextInt(33)+1));
        }
        System.out.println("蓝：" + (r.nextInt(16)+1));
    }

    public static void daletou(){
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(r.nextInt(35)+1);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(r.nextInt(12)+1);
        }

    }
    public static void main(String[] args) {
        daletou();

    }
}
