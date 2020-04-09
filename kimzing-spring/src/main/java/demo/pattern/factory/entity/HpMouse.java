package demo.pattern.factory.entity;

/**
 * 惠普鼠标.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 10:28
 */
public class HpMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Hp Click");
    }
}
