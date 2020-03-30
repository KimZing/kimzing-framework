package com.kimzing.demo.factory.abstractf;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 14:22
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        ComputerFactory computerFactory = new DellComputerFactory();
        computerFactory.createKeyboard().beat();
        computerFactory.createMouse().click();
    }

}
