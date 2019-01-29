package com.diedline.exer;

@FunctionalInterface
public interface MyInterface<T,R> {
    public  R getValue(T t1,T t2);
}
