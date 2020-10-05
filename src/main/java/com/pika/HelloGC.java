package com.pika;

/**
 * @author Pika
 * @create 2020/10/2
 * @since 1.0.0
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        1
        System.out.println("helloGC******");
        Thread.sleep(Integer.MAX_VALUE);

//        2
//        long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量
//        long maxMemory = Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存值
//        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "字节、 " + (totalMemory / (double)1024 / 1024) + "MB");
//        System.out.println("MAX_MEMORY(-Xms) = " + maxMemory + "字节、 " + (maxMemory / (double)1024 / 1024) + "MB");

//        3
//        byte[] byteArry = new byte[10 * 1024 * 1024];
    }
}
