package com.bingfa;

/**
 * @author Tan Lianwang
 * @title: SynchronizedTest
 * @date 2022/1/25 11:12
 */

/**
 * 上述的代码，第一个方法时用了同步代码块的方式进行同步，传入的对象实例是this，表明是当前对象
 * ，当然，如果需要同步其他对象实例，也不可传入其他对象的实例；第二个方法是修饰方法的方式进行同步。
 * 因为第一个同步代码块传入的this，所以两个同步代码所需要获得的对象锁都是同一个对象锁，
 * 下面main方法时分别开启两个线程，分别调用test1和test2方法，那么两个线程都需要获得该对象锁，
 * 另一个线程必须等待。上面也给出了运行的结果可以看到：直到test2线程执行完毕
 * ，释放掉锁，test1线程才开始执行。
 * （可能这个结果有人会有疑问，代码里面明明是先开启test1线程，为什么先执行的是test2呢？
 * 这是因为java编译器在编译成字节码的时候，会对代码进行一个重排序，也就是说，编译器会根据实际情况对代码进行一个合理的排序
 * ，编译前代码写在前面，在编译后的字节码不一定排在前面，所以这种运行结果是正常的， 这里是题外话，最主要是检验synchronized的用法的正确性
 */
public class SynchronizedTest {
    public void test1() {
        // 锁的是当前类的实例化对象
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }


    public void obj2() {
        //在方法体内，，多线程访问不会阻塞，因为不是同一个对象，锁是不同的
        //String重写了hashcode所以地址不同但是hashcode相同.比较new String的地址需要用identityHashCode。
        String str= "lock";
//        String str = new String("lock");
//        Object str = new Object();
        System.out.println(Thread.currentThread().getName() + "内存地址:" + System.identityHashCode(str));
        System.out.println(Thread.currentThread().getName() + "hash值:" + str.hashCode());
        synchronized (str) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    //  锁的是当前类实例化的对象
    public synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
        }
    }

    //锁住的是整个类
    public synchronized static void test3() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
        }
    }

    //类锁 锁的是当前类
    public void test4() {
        synchronized (SynchronizedTest.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest myt2 = new SynchronizedTest();
        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.test3();
                System.out.println("释放掉锁1");
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.test4();
                myt2.obj2();
                System.out.println("释放掉锁2");

            }
        }, "test2");

        test1.start();
        test2.start();
        myt2.obj2();


    }


}
