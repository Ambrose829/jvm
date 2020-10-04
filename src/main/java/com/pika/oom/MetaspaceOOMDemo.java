package com.pika.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 *
 * java 8之后版本使用元空间代替永久代
 *
 * Metaspace是方法区在HotSpot中的实现，它与永久代的区别在于，元空间并不在虚拟机内存中而是使用本地内存
 * 也即，在java8中class meta(the virtual machines internal presentation of Java class)，被存储在metaspace中的native memory
 * 永久代（8以后被元空间取代）存放了如下信息
 *
 * 虚拟机加载的类信息
 * 常量池
 * 静态变量
 * 即时编译后的代码
 *
 * 模拟Metaspace空间溢出，我们不断生成类向空间中灌。类占据的空间总是会超过Metaspace指定的空间大小
 *
 *
 * JVM参数配置
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *
 */
public class MetaspaceOOMDemo {
    public static void main(String[] args) {
        int i = 0;//模拟计数多少次以后发生异常
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("===============多少次后OOM" + i);
            e.printStackTrace();
        }
    }

    static class OOMTest{

    }
}
