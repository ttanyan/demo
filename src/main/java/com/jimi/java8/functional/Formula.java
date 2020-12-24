package com.jimi.java8.functional;

/**
 * 允许在接口中实现默认函数的实现
 */
interface Formula {
    /**
     * 根据姓名查找人员信息
     * @param id
     * @return
     */
     String findSalaryByName(String id);

    /**
     * 计算工资
     * @param salary 月薪
     * @return 年薪
     */
    default  long calculateSalary(int salary){
        return salary* 12L;
     }
}
