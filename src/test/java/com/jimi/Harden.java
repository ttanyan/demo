package com.jimi;


/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/5/11 15:10
 */
public class Harden {

    public static void main(String[] args) {
        float money = 25;

        for (int i = 1; i <=100; i++) {
            money += money * 0.03;
            System.out.println("第 " + i + " 次涨停，资金为:" + money);

            if(money >=302){
                System.out.println("=========第 " + i + " 次涨停，资金为:" + money);
            }

        }

    }
}
