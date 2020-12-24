package com.jimi.java8.lambda;

/**
 * @author test
 */
public class DeLambdaTest {
    public static void main(String[] args) {
        //通过 ::  实现对方法或构造函数的引用
        DeLambda<String,Integer> deLambda = Integer::valueOf;
        Integer converted = deLambda.convert("123");
        System.out.println(converted);
        PersonFactory<Person> personPersonFactory =  Person::new;
        Person person = personPersonFactory.create("hello", "word");
        System.out.println(person.firstName);
    }
}
