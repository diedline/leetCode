package com.diedline.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 中内置的四大核心函数式接口
 * Consumer<T> 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> 供给型接口
 *      T get();
 *
 * Function<T,R> 函数型接口
 *      R apply(T t1,T t2)  可以传多个参数
 *
 * Predicate<T> 断言型接口
 *      boolean test(T t);
 */
public class TestLambda3 {
    //Consumer<T> 消费型接口
    @Test
    public void test1(){
        happy(10000,(m) -> System.out.println("出去保健消费"+m+"元"));
    }
    public void happy(double money, Consumer<Double> con  ){
        con.accept(money);
    }

    //Supplier<T> 供给型接口
    @Test
    public void test2(){
        //使用math的random 方法 每次产生十个随机数
        List<Integer> list = getNum(10,()-> (int) (Math.random() * 100));
        for (Integer a:list
             ) {
            System.out.println(a);
        }
    }
    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNum(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();     //创建集合
        for (int i = 0; i < num;i++){
            Integer a = supplier.get();
            list.add(a);
        }
        return list;
    }

    //Function<T,R> 函数型接口
    @Test
    public void test3(){
        //小写转大写
        String a = strOpr("abcde", String::toUpperCase);
        System.out.println(a);
        //去除空格
        String b = strOpr("\t\t我的方法 ",String::trim);
        System.out.println(b);
    }

    //需求：用于处理字符串
    public String strOpr(String a, Function<String,String> function){
        return function.apply(a);
    }



    //Predicate<T> 断言型接口

    //需求:将满足条件的字符串放入到集合中
    @Test
    public void test4(){
        List<String> list= Arrays.asList("hello","123","Lambda","www","OK");
        //过滤获取字符长度大于3的字符串
        List<String> strList = getList(list,(a) -> a.length()>3);
        for (String a:strList
             ) {
            System.out.println(a);
        }
    }
    public  List<String> getList(List<String> list, Predicate<String> predicate){
        List<String> strlist = new ArrayList<>();
        for (String a:list
             ) {
            if(predicate.test(a)){
                strlist.add(a);
            }
        }
        return strlist;
    }

}
