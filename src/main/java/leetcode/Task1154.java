package leetcode;

import java.time.LocalDate;

public class Task1154 {
    public static void main(String[] args) {
        System.out.println(new Task1154().dayOfYear("2019-01-09"));
        System.out.println(new Task1154().dayOfYear("2019-02-10"));
        System.out.println(new Task1154().dayOfYear("2003-03-01"));
        System.out.println(new Task1154().dayOfYear("2004-03-01"));
    }

    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }
}
