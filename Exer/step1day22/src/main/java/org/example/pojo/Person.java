package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int salary;
    private String address;
    private int email;

    public void show() {
        System.out.println("show()");
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int getSum(int a, int b) {
        return a + b;
    }

    private static String concat(String a, String b, int c) {
        return a + b + c;
    }
}
