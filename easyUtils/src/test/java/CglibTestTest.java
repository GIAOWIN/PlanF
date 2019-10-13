import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTestTest implements MethodInterceptor {
       public static final Cglibtest cglibtest = new Cglibtest();

    public static void main(String[] args) {
        CglibTestTest cglibTestTest = new CglibTestTest();
        cglibtest.test1("test1");
        cglibtest.test2("test2");

        Object o = Enhancer.create(cglibtest.getClass(), cglibTestTest);
    }

    /**
     * 增强方法
     * @param prxy
     * @param method
     * @param args
     * @param methodProxy 当前执行方法的代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object prxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept 执行了 " + prxy);
            Object ret = null;
            String str = (String) args[0];
            if ("test1".equals(method.getName())) {
                System.out.println("我被 " + method + " 方法调用了,参数是 " + str);

//                Cglibtest invoke = (Cglibtest)method.invoke(ar);
                ret = method.invoke(cglibtest, args[0]);
            }
            return ret;
    }

//    public static void main(String[] args) {
//
//
//        Object prxyTest = Enhancer.create(Cglibtest.class, () (obj, method, ar, proxy) -> {
//            Object ret = null;
//            String str = (String) ar[0];
//            if ("test1".equals(method.getName())) {
//                System.out.println("我被 " + method + " 方法调用了,参数是 " + str);
//
////                Cglibtest invoke = (Cglibtest)method.invoke(ar);
//                ret = method.invoke(cglibtest, ar[0]);
//            }
//            return ret;
//        });
//
//    }
}
