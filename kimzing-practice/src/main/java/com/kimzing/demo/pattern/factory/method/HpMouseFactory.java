package com.kimzing.demo.pattern.factory.method;

import com.kimzing.demo.pattern.factory.entity.HpMouse;
import com.kimzing.demo.pattern.factory.entity.Mouse;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 12:30
 */
public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
