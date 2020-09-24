package com.jimi.utils;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import org.springframework.util.CollectionUtils;
import sun.text.CollatorUtilities;

public class Null {


  public static void main(String[] args) {
    List<String> s = Lists.newArrayList();
    System.out.println(CollectionUtils.isEmpty(s));
    List<String> b = Lists.newArrayList("1","2","3");
    Object[] c = b.toArray();
    System.out.println(c[1]+"100");
    System.out.println(Objects.nonNull(s));
    System.out.println(Objects.requireNonNull(s));
    System.out.println(s.toArray().length == 0);
    String qw = String.join("",b);
    System.out.println(qw);
  }
}
