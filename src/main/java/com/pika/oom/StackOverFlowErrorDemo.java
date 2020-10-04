package com.pika.oom;

/**
 * @author Pika
 * @create 2020/10/4
 * @since 1.0.0
 *
 * java.lang.StackOverFlowError
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlowError();
    }

    private static void stackOverFlowError() {
        stackOverFlowError();
    }
}
