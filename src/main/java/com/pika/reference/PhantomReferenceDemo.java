package com.pika.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author Pika
 * @create 2020/10/3
 * @since 1.0.0
 *
 * java提供了四种引用类型，在垃圾回收的时候，都有各自的特点。
 * ReferenceQueue是用来配合引用工作的，没有ReferenceQueue一样可以运行
 * 这相当于是一种通知机制
 *
 * 当关联的引用队列中有数据的时候，意味着引用指向堆内存中的对象被回收。
 * 通过这种方式，JVM允许我们在对象销毁后，做一些我们希望做的事情
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());


        System.out.println("=================");

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }

}
