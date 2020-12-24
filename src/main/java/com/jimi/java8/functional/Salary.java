package com.jimi.java8.functional;

/**
 * @author test
 */
public class Salary implements Formula{
    @Override
    public String findSalaryByName(String id) {
        //1根据id查找对应的人和月薪 省略
        Long salary = calculateSalary(8000);
        return "张三的薪水是"+salary;
    }

}
