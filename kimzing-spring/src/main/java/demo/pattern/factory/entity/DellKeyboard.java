package demo.pattern.factory.entity;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 14:19
 */
public class DellKeyboard implements Keyboard {
    @Override
    public void beat() {
        System.out.println("戴尔 键盘");
    }
}
