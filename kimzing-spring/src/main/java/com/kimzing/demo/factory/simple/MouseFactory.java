package com.kimzing.demo.factory.simple;

import com.kimzing.demo.factory.entity.DellMouse;
import com.kimzing.demo.factory.entity.HpMouse;
import com.kimzing.demo.factory.entity.Mouse;

/**
 * 鼠标工厂.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 10:28
 */
public class MouseFactory {

    public static Mouse createMouse(int type) {
        switch (type) {
            case 0:
                return new DellMouse();
            case 1:
                return new HpMouse();
            default:
                return new DellMouse();
        }
    }

    public static void main(String[] args) {
        createMouse(1).click();
        createMouse(2).click();
    }

}
