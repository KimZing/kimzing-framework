package com.kimzing.demo.pattern.factory.abstractf;

import com.kimzing.demo.pattern.factory.entity.DellKeyboard;
import com.kimzing.demo.pattern.factory.entity.DellMouse;
import com.kimzing.demo.pattern.factory.entity.Keyboard;
import com.kimzing.demo.pattern.factory.entity.Mouse;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 14:09
 */
public class DellComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
