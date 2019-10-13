import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ExPerson {
    public static final Person person = new Person();

    public static void main(String[] args) {
        final Student student = (Student) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new ExMethod(person)
        );
        student.learn();

    }
}

class ExMethod implements InvocationHandler {
    Person person;

    public ExMethod(Person person) {
        this.person = person;
    }

    /**
     * @param proxy  代理对象的引用
     * @param method 当前执行的方法
     * @param args   当前执行的方法的参数
     * @return 和被代理对象方法有相同返回值类型
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我被 " + method + " 方法调用了,参数是 " + Arrays.toString(args));
        //返回值
        Person invoke = (Person) method.invoke(person, args);
        return invoke;
    }
}

