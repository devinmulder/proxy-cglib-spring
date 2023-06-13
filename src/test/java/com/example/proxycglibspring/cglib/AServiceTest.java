package com.example.proxycglibspring.cglib;

import com.example.proxycglibspring.proxy.A;
import com.example.proxycglibspring.proxy.AImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class AServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a1() {

        AService target = new AService();

        AService proxy = (AService) Enhancer.create(
                AService.class,
                new MethodInterceptor() {

                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                        method.invoke(target);
                        methodProxy.invoke(target, objects);
                        System.out.println("AServiceTest.intercept");
                        return null;
                    }
                }
        );

        proxy.a1();
        proxy.a2();
    }

    @Test
    void a2() {

        AImpl target = new AImpl();

        AImpl proxy = (AImpl) Enhancer.create(
                AImpl.class,
                new Class[]{A.class},
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                        method.invoke(target);
                        methodProxy.invoke(target, objects);
                        System.out.println("AServiceTest.intercept");
                        return null;
                    }
                }
        );

        proxy.a1();
        proxy.a2();

    }
}