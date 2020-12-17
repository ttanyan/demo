package com.jimi.annotations;

/**
 * 懒加载的注解使用
 */
public class Lazy {

  private String name;
  private String age;

  public Lazy() {
  }

  public Lazy(String name, String age) {
    System.out.println("对象被创建了...........");
    this.name = name;
    this.age = age;
  }


  /**
   * Gets the value of name.
   *
   * @return the value of name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name name
   * @return this
   */
  public Lazy setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the value of age.
   *
   * @return the value of age
   */
  public String getAge() {
    return age;
  }

  /**
   * Sets the age.
   *
   * @param age age
   * @return this
   */
  public Lazy setAge(String age) {
    this.age = age;
    return this;
  }
}
