import org.example.pojo.AtguiguStudent;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAtguiguStudent {
    @Test
    public void test1() {
        System.out.println(AtguiguStudent.class.getConstructors());
        System.out.println(AtguiguStudent.class.getName());
        System.out.println(AtguiguStudent.class.getClass());
        System.out.println(AtguiguStudent.class.getMethods());
        System.out.println(AtguiguStudent.class.getPackageName());
    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        Field field = AtguiguStudent.class.getDeclaredField("school");
        field.setAccessible(true);
        field.set(null, "尚硅谷");
        Object object = field.get(null);
        System.out.println(object);
    }

    @Test
    public void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("org.example.pojo.AtguiguStudent");
        Object object = aClass.newInstance();
        Field field = aClass.getDeclaredField("className");
        field.setAccessible(true);
        Object object1 = field.get(object);
        System.out.println(object1);
        field.set(object, "20230713");
        System.out.println(object1);
    }

    @Test
    public void test4() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<AtguiguStudent> atguiguStudentClass = AtguiguStudent.class;
        Constructor constructor = atguiguStudentClass.getDeclaredConstructor(String.class);
        Object object1 = constructor.newInstance("123");
        Object object2 = constructor.newInstance("1234");
        Method compareTo = atguiguStudentClass.getDeclaredMethod("compareTo", Object.class);
        System.out.println(compareTo.invoke(object1, object2));
    }
}
