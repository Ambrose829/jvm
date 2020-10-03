package com.pika;

import java.lang.ref.WeakReference;

/**
 * @author Pika
 * @create 2020/10/3
 * @since 1.0.0
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;

        System.gc();
        System.out.println("==========回收");
        System.out.println(o1);
        System.out.println(weakReference.get());

    }
}
