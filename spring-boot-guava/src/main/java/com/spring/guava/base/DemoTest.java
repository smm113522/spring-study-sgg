package com.spring.guava.base;

import com.google.common.base.Joiner;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;


/**
 * https://www.w3cschool.cn/article/17770773.html
 */
public class DemoTest {

    public static void main(String[] args) {
        Table<String, String, Object> table = HashBasedTable.create();
        table.put("123", "demo1", Lists.newArrayList());
        table.put("456", "demo2", Lists.newArrayList());
        table.put("789", "demo3", Lists.newArrayList());
        table.put("1231", "demo4", Lists.newArrayList());
        table.put("1232", "demo5", Lists.newArrayList());
        System.out.println(table);

        List<Integer> list = Lists.newArrayList();
        list.add(34);
        list.add(64);
        list.add(267);
        list.add(865);
        String result = Joiner.on("-").join(list);
        System.out.println(result);
//        输出：34-64-267-865
    }

}
