package com.liuxg.money.constant;

public enum CheckType {

    consume("消费"),
    income("收入"),
    forget("补录"),
    wish("许愿"),
    start("初始"),
    end("结束");

    private String name;

    CheckType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
