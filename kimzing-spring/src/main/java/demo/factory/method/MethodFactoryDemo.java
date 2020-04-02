package demo.factory.method;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 12:30
 */
public class MethodFactoryDemo {

    public static void main(String[] args) {
        MouseFactory factory = new DellMouseFactory();
        factory.createMouse().click();
    }

}
