package com.example.demo.reflect;

import com.example.demo.proxy.RealSubject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/30 11:16
 **/
public class ReflectClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1、getClass
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass().getName());//com.example.demo.proxy.RealSubject

        //2、类.class.getName()
        System.out.println(RealSubject.class.getName());

        //3、Class.forName("类路径").getName()
        Class c = Class.forName("com.example.demo.proxy.Subject");
        System.out.println(c.getName()); //com.example.demo.proxy.Subject

        //获取构造方法
        System.out.println("--------------获取所有公用的构造方法---------------");
        Constructor[] constructors = Person.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("--------------获取所有的构造方法---------------");
        Constructor[] constructors2 = Person.class.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println(constructor);
        }

        System.out.println("--------------获取公有&无参的构造方法---------------");
        Constructor<Person> constructor1 = Person.class.getConstructor(null);
        System.out.println(constructor1);

        System.out.println("--------------获取私有&有参的构造方法---------------");
        Constructor<Person> constructor2 = Person.class.getDeclaredConstructor(new Class[]{String.class,int.class});
        System.out.println(constructor2);

        //获取属性字段
        Field name = Person.class.getDeclaredField("name");
        Person person = Person.class.getConstructor().newInstance();
        name.setAccessible(true);
        name.set(person,"小明");
        System.out.println(person.getName());

        //获取方法method
        System.out.println("teacher 方法");
        Class<?> teacher = Class.forName("com.example.demo.reflect.Teacher");
        //Method[] methods = teacher.getMethods();//包括继承来的方法
        Method[] methods = teacher.getDeclaredMethods();//只有本类的方法
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println(Person.class.isAssignableFrom(Teacher.class));//teacher是person的子类

        Object o = teacher.getConstructor().newInstance();
        Method teacherMethod = teacher.getDeclaredMethod("s", String.class);
        teacherMethod.invoke(o,"  teacher");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,0);
        Date time =   calendar.getTime();
    }
}
