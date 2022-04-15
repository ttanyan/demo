package com.bingfa.thread;

import lombok.SneakyThrows;

import java.time.LocalDateTime;

/**
 * @author Tan Lianwang
 * @title: VolatileVisibilitySample
 * @date 2022/1/24 17:27
 */
public class VolatileVisibilitySample {
    volatile boolean flag = true;

    public void save(){
        this.flag = false;
        String name = Thread.currentThread().getName();
        System.out.println("线程 " +name+ " 修改了 flag的值"+flag);
    }

    public void load(){
        String name = Thread.currentThread().getName();
        while (flag){
            //空跑，等待flag的改变

            System.out.println("空跑，等待flag改变 "+ LocalDateTime.now());

        }
        System.out.println("线程"+name+"感知到了flag的变化为： "+flag);
    }

    @SneakyThrows
    public static void main(String[] args) {
        VolatileVisibilitySample volatileVisibilitySample = new VolatileVisibilitySample();

        Thread threadA = new Thread(() -> {
            volatileVisibilitySample.save();
        },"ThreadA");

        Thread threadB = new Thread(() -> {
            volatileVisibilitySample.load();
        },"ThreadB");

        threadB.start();

        Thread.sleep(1000);

        threadA.start();


    }




}
