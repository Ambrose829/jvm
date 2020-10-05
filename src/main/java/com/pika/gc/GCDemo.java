package com.pika.gc;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 *
 *1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC			(DefNew+Tenured)
 *
 * 2
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC			ParNew+Tenured)
 *
 * 3
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC		(PSYoungGen+ParOldGen)
 *
 * 4
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC	(PSYoungGen+ParOldGen)
 *  不加载默认配置	UseParallelGC
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags 							(PSYoungGen+ParOldGen)
 *
 * 5
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC	(ParNew+CMS)
 *
 * 6
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC				()
 *
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("GC Demo");
        byte[] bytes = new byte[15 * 1024 * 1024];
    }
}
