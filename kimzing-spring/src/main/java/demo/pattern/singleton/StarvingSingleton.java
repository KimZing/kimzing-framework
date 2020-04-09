package demo.pattern.singleton;

/**
 * 饿汉模式.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/9 20:23
 */
public class StarvingSingleton {

    private static final StarvingSingleton STARVING_SINGLETON = new StarvingSingleton();

    private StarvingSingleton() { }

    public static StarvingSingleton getInstance() {
        return STARVING_SINGLETON;
    }

    public static void main(String[] args) {
        StarvingSingleton instance1 = StarvingSingleton.getInstance();
        StarvingSingleton instance2 = StarvingSingleton.getInstance();
        System.out.println(instance1 == instance2);

    }

}
