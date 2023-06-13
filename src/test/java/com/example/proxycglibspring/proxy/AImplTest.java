package com.example.proxycglibspring.proxy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class AImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void a1() {

        AImpl target = new AImpl();

        A proxy = (A) Proxy.newProxyInstance(
                A.class.getClassLoader(),
                new Class[]{A.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        method.invoke(target);
                        System.out.println("AImplTest.invoke");
                        return null;
                    }
                }
        );

        proxy.a1();
        proxy.a2();

    }

    @Test
    void a2() {
    }
}