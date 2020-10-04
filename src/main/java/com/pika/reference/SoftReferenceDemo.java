package com.pika.reference;

import java.lang.ref.SoftReference;

/**
 * @author Pika
 * @create 2020/10/3
 * @since 1.0.0
 *
 * 内存够用就保留，不够用就回收
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1 = null;
        System.gc();
        try {
           byte[] byteArray = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println(o1);
            System.out.println(softReference.get());
        }


    }
}
