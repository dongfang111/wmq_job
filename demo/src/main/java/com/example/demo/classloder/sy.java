package com.example.demo.classloder;

import com.example.demo.entity.ListNode;

public class sy {
    public static void main(String[] args) {
        ListNode o= new ListNode(1);
        ClassLoader classLoader = o.getClass().getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }
}

