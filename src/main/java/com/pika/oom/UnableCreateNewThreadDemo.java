package com.pika.oom;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 * 高并发请求服务器时，将常出现以下异常：java.lang.OutOfMemoryError:  unnable to create new native thread
 * 准确的讲该native thread异常与对应的平台有关
 *
 * 导致原因：
 *
 *      你的应用创建了太多的线程了，一个应用进程创建了太多线程，超过了系统的承载极限。
 *      你的服务器不允许你的应用程序创建这么多线程，linux系统默认允许单个线程创建最多为1024个线程；你的应用创建超过这个数量的线程就会出现异常：java.lang.OutOfMemoryError:  unnable to create new native thread
 *
 * 解决办法：
 *      想办法降低自己的应用程序创建线程的数量，分析应用是否真的需要创建这么多线程，如果不是，改代码讲线程数降到最低
 *      对于有的应用，确实需要创建很多线程的，远超过linux系统的默认1024个线程，可以通过修改linux服务器配置，扩大linux默认限制
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i = 1;  ; i++) {
            System.out.println("=============" + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
}
