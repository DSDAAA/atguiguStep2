package org.example.lambda.pojo;

import org.example.lambda.impl.Fly;

public class Bird implements Fly {

    @Override
    public void fly() {
        System.out.println("小鸟飞");
    }
}
