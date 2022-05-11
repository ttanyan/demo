package com.jimi;


/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/5/11 15:10
 */
public class Harden {

    public static void main(String[] args) {
        int money = 20;

        for (int i = 1; i < 11; i++) {
            money += money * 0.1;
            System.out.println("第 " + i + " 次涨停，资金为:" + money);
            if(money == 39){
                System.out.println((1/40.0)*100);
            }
        }

    }
}
