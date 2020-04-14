package com.kimzing.demo.pattern.factory.entity;

/**
 * 戴尔鼠标.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 10:27
 */
public class DellMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Dell Click");
    }
}
