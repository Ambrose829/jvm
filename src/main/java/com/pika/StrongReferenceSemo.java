package com.pika;

/**
 * @author Pika
 * @create 2020/10/3
 * @since 1.0.0
 */
public class StrongReferenceSemo {
    public static void main(String[] args) {
        Object obj1 = new Object();//这样定义的就是强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1 = null;//置空
        System.gc();
        System.out.println(obj2);

    }
}
