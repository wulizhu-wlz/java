package com.ipaynow.bcfinance.proxy;

/**
 * @author Wu
 * @date 2020-03-12 13:56
 */
public class PeopleImpl implements People {

    @Override
    public void work() {
        System.out.println("工作");
    }

    public static void main(String[] args) {
        PeopleImpl people = new PeopleImpl();
        MbsProxy<People> mbsProxy = new MbsProxy<People>();
        People people1 = (People) mbsProxy.bind(people);
        people1.work();
    }
}
