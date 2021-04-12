package com.example.demo.jvm;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * 沿用双亲委派机制自定义类加载器
 * 只需要重写findClass()方法
 *
 * @author wmqing
 * @Date 2021/4/12 19:42
 **/
public class TestClassLoader extends ClassLoader {

    private String name;

    public TestClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public Class<?> loadClass(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File("d:/Test.class"));
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

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {

    }
}
