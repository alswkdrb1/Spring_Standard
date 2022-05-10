package com.spring.fastcampus.controller.BeforeNo9;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodCall {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Hello hello = new Hello();
//        hello.main();//private라서 외부 호출 불가

        //Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
        //java.lang.reflect패키지를 제공
        //Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어 온다.
        Class helloClass = Class.forName("ctx.Controller.Hello");
        Hello hello = (Hello)helloClass.newInstance();
        Method main = helloClass.getDeclaredMethod("main");
        main.setAccessible(true); //private인 main()을 호출가능하게 한다.

        main.invoke(hello);//hello.main();
    }
}
