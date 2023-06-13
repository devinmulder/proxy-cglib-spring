package com.example.proxycglibspring.proxy;

public class AImpl implements A {

    public AImpl() {
        System.out.println("AImpl.AImpl");
    }

    @Override
    public void a1() {
        System.out.println("AImpl.a1");
    }

    @Override
    public void a2() {
        System.out.println("AImpl.a2");
    }
}
