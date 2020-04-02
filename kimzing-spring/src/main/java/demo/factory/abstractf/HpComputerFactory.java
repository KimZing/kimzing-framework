package demo.factory.abstractf;

import demo.factory.entity.HpKeyboard;
import demo.factory.entity.HpMouse;
import demo.factory.entity.Keyboard;
import demo.factory.entity.Mouse;

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
