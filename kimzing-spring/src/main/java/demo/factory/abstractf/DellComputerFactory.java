package demo.factory.abstractf;

import demo.factory.entity.DellKeyboard;
import demo.factory.entity.DellMouse;
import demo.factory.entity.Keyboard;
import demo.factory.entity.Mouse;

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
