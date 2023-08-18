import org.example.pojo.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonTest {
    @Test
    public void test() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.toString());
        }
    }

    @Test
    public void test1() {
        Person person = new Person();
        Class<? extends Person> personClass = person.getClass();
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.toString());
        }
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> person = Class.forName("org.example.pojo.Person");
        Constructor<?>[] declaredConstructors = person.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.toString());
        }
    }

    @Test
    public void test3() throws ClassNotFoundException {
        ClassLoader classLoader = Class.forName("org.example.pojo.Person").getClassLoader();
        Constructor<?>[] declaredConstructors = classLoader.getClass().getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.toString());
        }
    }

    @Test
    public void test4() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("org.example.pojo.Person");
        Constructor<?> declaredConstructors = aClass.getDeclaredConstructor(String.class, int.class, String.class, int.class);
        declaredConstructors.setAccessible(true);
        Object newInstance = declaredConstructors.newInstance("aaa", 12, "bb", 30);
        System.out.println(newInstance.toString());
    }

    @Test
    public void test5() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("org.example.pojo.Person");
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        Object newInstance = aClass.newInstance();
        name.set(newInstance, "123");
        System.out.println(newInstance);
    }

    @Test
    public void test6() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    @Test
    public void test7() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("org.example.pojo.Person");
        Method getSum = aClass.getDeclaredMethod("getSum", int.class, int.class);
        getSum.setAccessible(true);
        System.out.println(getSum.invoke(aClass, 10, 20));

    }
}
