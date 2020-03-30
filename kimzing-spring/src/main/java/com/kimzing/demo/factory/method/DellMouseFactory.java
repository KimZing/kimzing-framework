package com.kimzing.demo.factory.method;

import com.kimzing.demo.factory.entity.DellMouse;
import com.kimzing.demo.factory.entity.Mouse;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 12:29
 */
public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
