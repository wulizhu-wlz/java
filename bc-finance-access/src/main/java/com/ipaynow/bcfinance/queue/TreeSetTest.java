package com.ipaynow.bcfinance.queue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.TreeSet;

/**
 * @author Wu
 * @date 2020-03-18 14:30
 */
public class TreeSetTest {


    public static void main(String[] args) {
        String sourceStr = "[{\"id\":\"1\",\"pid\":\"0\",\"name\":\"test-1\",\"level\":\"1\"},{\"id\":\"2\",\"pid\":\"0\",\"name\":\"test-2\",\"level\":\"1\"}" +
                ",{\"id\":\"3\",\"pid\":\"2\",\"name\":\"test-3\",\"level\":\"2\"},{\"id\":\"4\",\"pid\":\"1\",\"name\":\"test-4\",\"level\":\"2\"}" +
                ",{\"id\":\"5\",\"pid\":\"3\",\"name\":\"test-5\",\"level\":\"3\"}]";
        JSONArray list = JSON.parseArray(sourceStr);
        TreeSet<Object> ts = new TreeSet<>();
        for (Object o : list) {
            JSONObject jsonObject = (JSONObject) o;
            Person person2 = JSON.parseObject(jsonObject.toJSONString(), Person.class);
            ts.add(person2);
        }
        System.out.println(ts);
    }

    @Data
    public static class Person implements Comparable<Person> {
        private String id;
        private String pid;
        private String name;
        private String level;


        @Override
        public int compareTo(Person o) {
            return Integer.valueOf(this.level) - Integer.valueOf(o.level);
        }
    }
}
