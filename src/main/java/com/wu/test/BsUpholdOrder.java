package com.wu.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BsUpholdOrder {

    private static final long serialVersionUID = 1L;

    /**
     * 保养日期
     */
    private LocalDate upholdDate;

    /**
     * 实际保养人
     */
    private String upholdPerson;

    public BsUpholdOrder() {
    }

    public BsUpholdOrder(LocalDate upholdDate, String upholdPerson) {
        this.upholdDate = upholdDate;
        this.upholdPerson = upholdPerson;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public LocalDate getUpholdDate() {
        return upholdDate;
    }

    public void setUpholdDate(LocalDate upholdDate) {
        this.upholdDate = upholdDate;
    }

    public String getUpholdPerson() {
        return upholdPerson;
    }

    public void setUpholdPerson(String upholdPerson) {
        this.upholdPerson = upholdPerson;
    }

    @Override
    public String toString() {
        return "BsUpholdOrder{" +
                "upholdDate=" + upholdDate +
                ", upholdPerson='" + upholdPerson + '\'' +
                '}';
    }


    public static void main(String[] args) {
        List<BsUpholdOrder> orders = new ArrayList<>();
        BsUpholdOrder order1 = new BsUpholdOrder();
        order1.setUpholdPerson("张三1");
        order1.setUpholdDate(LocalDate.now());
        BsUpholdOrder order2 = new BsUpholdOrder();
        order2.setUpholdPerson("张三2");
        order2.setUpholdDate(LocalDate.now().withMonth(9));
        BsUpholdOrder order3 = new BsUpholdOrder();
        order3.setUpholdPerson("张三3");
        order3.setUpholdDate(LocalDate.now());
        BsUpholdOrder order4 = new BsUpholdOrder();
        order4.setUpholdPerson("张三4");
        order4.setUpholdDate(LocalDate.now().withMonth(8));
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        //分组 按月
        Map<Integer,List<BsUpholdOrder>> groupByMonth = orders.stream().collect(Collectors.groupingBy(o -> o.getUpholdDate().getMonthValue()));
        System.out.println(groupByMonth);
    }
}