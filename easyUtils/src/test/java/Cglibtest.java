import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


public class Cglibtest {


    public static void test1(String name) {
        System.out.println(name);
    }

    public static void test2(String name) {
        System.out.println(name);
    }


}
