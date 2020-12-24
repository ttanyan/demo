package com.jimi.java8.lambda;

@FunctionalInterface
public interface DeLambda<F,T> {
    /**
     *  将F装换成T
     * @param from 需要转换的类型
     * @return T 转换的类型
     */
    T convert(F from);
}
