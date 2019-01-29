package com.diedline.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一.Stream 的三个操作步骤
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作（终端操作）
 */
public class TestStreamAPI1 {
    //创建Stream 的方法
    @Test
    public void test1(){
        //1.可以通过Collection 系列集合提供的stream() 串行流或parallelStream 并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream() 获取数组流
        Employee[] employees =  new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3.通过Stream 类中的静态方法of()来获取流
        Stream<String> stream2 = Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代创建无限流
        Stream<Integer> stream3 = Stream.iterate(0,(x) ->x+2);
        stream3.limit(10).forEach(System.out::println);

        //使用generate来生成无限流
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
