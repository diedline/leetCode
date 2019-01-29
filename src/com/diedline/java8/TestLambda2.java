package com.diedline.java8;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * Lambda 的基础语法 新的操作符 "->"  称为 lambda 操作符
 *                      该操作符将lambda 分为两部分
 * 左侧：Lambda 表达式中的参数列表
 * 右侧：Lambda中所需要的功能
 *
 * 语法格式一： 无参无返回值
 *  () ->System.out,println("123");
 * 语法格式二： 有一个参数，无返回值的方法
 *  (x) -> System.out.println(x);
 * 语法格式三：只有一个参数，小括号可以省略不写
 *  x -> System.out.println(x);
 * 语法格式四：有两个以上的参数，并且lambda体中有多条语句,需要使用大括号和return
 *    Comparator<Integer> con = (x,y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x,y);
 *         };
 * 语法格式五：若lambda体中只有一条语句,return 和大括号都可以省略不写
 *      Comparator<Integer> con = (x,y) ->  Integer.compare(x,y);
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为jvm的编译期可以通过上下文推断出数据类型
 *      (Integer x,Integer y) ->  Integer.compare(x,y);
 *
 * 左右遇一括号省
 * 左侧推断类型省
 *
 * 二：lambda表达式需要“函数式接口的支持”
 * 函数式接口：接口中只有一个抽象方法时，就是函数式接口可以使用 @FunctionalInterface 修饰
 *              可以检查是否是函数式接口
 * */
public class TestLambda2 {
    @Test
    public void test1(){
        //使用匿名内部类
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello,world!" + num);
            }
        };
        r.run();
        System.out.println("----------------");
        //使用lambda 表达式
        Runnable r1 = ()-> System.out.println("Hello,world!");
        r1.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("厉害了");
    }

    @Test
    public void test3(){
        Comparator<Integer> con = (x,y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        Comparator<Integer> con = (x,y) ->  Integer.compare(x,y);
    }

    @Test
    public void test5(){
        Comparator<Integer> con = (Integer x,Integer y) ->  Integer.compare(x,y);
        System.out.println(2);
    }

    //类型推断
    public void test6(){
//        String[] strs;
//        strs  = {"aaa","bbb","ccc"};
        List<String> list = new ArrayList<>();
        show(new HashMap<>());
    }

    public void show(Map<String,Integer> map){
    }

    //需求：对一个数进行运算
    @Test
    public void test7(){
        Integer num = operation(100,(x) -> x * x);
        System.out.println(num);
        System.out.println(operation(200,(y) -> y + 200));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }
}
