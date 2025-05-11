package com.example.servicepopoo.model;

public class Banker extends Player {

    public Banker(String id) {
        super(id);
    }

    @Override
    public void printPlayerInfo() {
        System.out.println("-------------------------------");
        System.out.println("--莊    家: " + id);
        System.out.println("--手    牌: " + hand);
        System.out.println("--點    數: " + getCurrentPoints());
        System.out.println("--全部注碼: " + totalPoints);
    }
}