package com.kimzing.demo.pattern.factory.abstractf;

import com.kimzing.demo.pattern.factory.entity.Keyboard;
import com.kimzing.demo.pattern.factory.entity.Mouse;

/**
 * 电脑相关产品生产工厂.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 14:08
 */
public interface ComputerFactory {

    Mouse createMouse();

    Keyboard createKeyboard();

}
