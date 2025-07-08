package com.jimi;

import com.google.common.collect.Lists;
import org.assertj.core.util.Strings;

import java.util.ArrayList;

/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/8/25 10:07
 */
public class test {

    public static void main(String[] args) {
        String s = "10.80.1.212:8983_solr,10.80.3.72:8983_solr,10.80.1.109:8983_solr,10.80.1.216:8983_solr,10.80.1.215:8983_solr,10.80.1.110:8983_solr,";
        String nodeUrl = convertClusterNodeUrl(s);
        System.out.println(nodeUrl);

    }
    public static String convertClusterNodeUrl(String clusterNode) {
        if(Strings.isNullOrEmpty(clusterNode)){
            return null;
        }
        StringBuilder buf = new StringBuilder();
        ArrayList<String> nodes = Lists.newArrayList(clusterNode.split(","));
        for (String node : nodes) {
            String temp = node.replaceAll("\\.|:|_", "-");
            String tempUrl = "<a href=\"https://" + temp + ".zhubajie.la\"" + ">" + node + "</a> ";
            buf.append(tempUrl);

        }



        return buf.toString();
    }
}
