package com.pika.oom;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 *
 *
 * java.lang.OutOfMemoryError: Java heap space
 *
 * JVM参数配置演示
 * -Xms10m -Xmx10m
 *
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
       byte[] byteArray = new byte[80 * 1024 * 1024]; //80m

    }
}
