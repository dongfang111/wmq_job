package com.example.demo.jvm;

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 沿用双亲委派机制自定义类加载器
 * 只需要重写findClass()方法
 *
 * @author wmqing
 * @Date 2021/4/12 19:42
 **/
public class TestClassLoader extends ClassLoader {

    public TestClassLoader() {
    }

    @Override
    public Class<?> findClass(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File(name));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        TestClassLoader test = new TestClassLoader();
        Class<?> aClass = test.loadClass("D:\\Test.class");
        Object o = aClass.newInstance();
    }
}
