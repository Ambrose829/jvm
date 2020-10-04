package com.pika.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 *
 * GC回收时间过长会抛出OutOfMemoryError，过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只回收了不到2%的极端情况下才会才会抛出.假如不抛出GC overhead limit 错误会发生什么情况呢？
 * 那就是GC清理这么点内存很快会再次被填满，迫使GC再次执行，这样就形成了恶性循环，
 * CPU使用率一直是100%，而GC却没有任何成果。
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 * JVM参数配置
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 *
 *
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<String>();

        try {
            while (true) {
                list.add(String.valueOf(++i));
            }
        } catch (Exception e) {
            System.out.println("新建出来多少的i： " + i);
            e.printStackTrace();
        }
    }
}
