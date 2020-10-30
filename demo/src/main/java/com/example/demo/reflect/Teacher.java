package com.example.demo.reflect;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/5/21 13:34
 **/
public class Teacher extends Person{

    public void teach(){
        System.out.println("teacher teaching.....");
    }

    public void s(String str){
        System.out.println("teacher static" + str);
    }
}
