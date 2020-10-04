package com.pika.oom;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 *
 * 写NIO程序经常使用ByteBuffer来读取或者写入数据，这时一种基于通道（Channel）与缓冲区（buffer）的I/O方式，
 * 它可以使用native函数库直接分配堆外内存，然后通过一个存储在Java堆里面的DirectByteBuffer对象作为这块内存的引用进行操作。
 * 这样能在一些场景中显著提高性能，因为避免了在Java堆和Native堆中来回复制数据。
 *
 * ByteBuffer.allocate(capability) 	第一种方式是分配JVM 堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢
 * ByteBuffer.allocateDirect(capability)	第二种方式是分配OS本地内存，不属于GC管辖范围，由于不需要内存拷贝所以相对较慢
 *
 * 但如果不断分配本地内存，堆内存很少使用，那么JVM就不需要执行GC，DirectByteBuffer对象们就不会被回收，
 * 这时候内存充足，但本地内存可能已经用光了，再次尝试分配本地内存就会出现OutOfMemory，那程序就直接崩溃了。
 *
 * 本地内存默认1/4
 *
 *
 *
 *JVM参数配置
 * -XX:MaxDirectMemorySize=5m
 *
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory：" + (sun.misc.VM.maxDirectMemory() / (double)1024 / 1024) + "MB");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
//        -XX:MaxDirectMemorySize=5m 我们配置5m实际使用6m
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);//6MB

    }
}
