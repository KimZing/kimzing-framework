package com.kimzing.demo.factory.entity;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 14:20
 */
public class HpKeyboard implements Keyboard {
    @Override
    public void beat() {
        System.out.println("惠普 键盘");
    }
}
