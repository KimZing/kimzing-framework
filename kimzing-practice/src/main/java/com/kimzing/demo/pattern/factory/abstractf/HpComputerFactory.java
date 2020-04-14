package com.kimzing.demo.pattern.factory.abstractf;

import com.kimzing.demo.pattern.factory.entity.HpKeyboard;
import com.kimzing.demo.pattern.factory.entity.HpMouse;
import com.kimzing.demo.pattern.factory.entity.Keyboard;
import com.kimzing.demo.pattern.factory.entity.Mouse;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 14:21
 */
public class HpComputerFactory implements ComputerFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
