package com.diedline.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 中止操作
 *
 */
public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99, Employee.Status.FREE),
            new Employee("李四",38,2323.99,Employee.Status.BUSY),
            new Employee("王五",78,4349.99,Employee.Status.VOCATION),
            new Employee("赵六",8,23539.99,Employee.Status.BUSY),
            new Employee("田气",16,91233.99,Employee.Status.BUSY),
            new Employee("田气",16,91233.99,Employee.Status.FREE),
            new Employee("田气",16,91233.99,Employee.Status.BUSY)
    );
    /**
     *   查找与匹配
     *
     * allMatch--检查是否匹配所有元素
     * anyMatch--检查是否匹配至少一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAny--返回当前流中的任意元素
     * count--返回流中元素的个数
     * max--返回流中的最大值
     * min--返回流中的最小值
     */
    @Test
    public void test1(){
        //allMatch判断是否匹配所有元素
        boolean b1 = employees.stream().allMatch((e) ->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        //anyMatch判断是否匹配至少一个元素
        boolean b2 = employees.stream().anyMatch((e) ->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        //noneMatch 判断是否所有都没匹配到
        boolean b3 = employees.stream().noneMatch((e) ->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);
        //Optional 这个容器能预防空指针异常 当有可能为空就将值扔入这个容器中
        //使用findFirst来获取找到的第一个值返回的Optional 容器
        Optional<Employee> op = employees.stream()
                .sorted((e1,e2) ->-Double.compare(e1.getSalary(),e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        //使用findAny 返回一个任意值
        Optional<Employee> op1 = employees.stream().filter((a) -> a.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op1.get());
        //如果使用parallelStream 并行流 使用findAny获取的值就能实现随机
        Optional<Employee> op2 = employees.parallelStream().filter((a) -> a.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test2(){
        Long count = employees.stream().count();
        System.out.println(count);
        //获取工资的最大值的员工
        Optional<Employee> op = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        op.ifPresent(System.out::println);
        //获取工资的最小值 因为要直接获取工资所以要使用map来提取流，然后使用min获取最小值
        Optional<Double> op1 = employees.stream()
                .map(Employee::getSalary)
                 .min(Double::compare);
        System.out.println(op1.get());
    }
    /**
     *  归约
     *  reduce(T identity,BinaryOperator) / reduce(BinaryOperator)  --可以将流中元素反复结合起来得到一个值
     *
     *  map--reduce的连接通常称为map--reduce模式，因Google用它来进行网络搜索而出名
     */
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,34,6,5,8,10,100);
        //reduce 第一个值是起始值
        Integer sum = list.stream().reduce(0,(x,y) ->x+y);
        System.out.println(sum);

        System.out.println("------------------------------");
        //使用reduce来获取工资总和
        Optional<Double> salary = employees.stream().map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(salary.get());
    }
}
