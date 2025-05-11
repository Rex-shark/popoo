package com.example.servicepopoo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gamer extends Player {

    private int currentBet; // 玩家當前注碼

    public Gamer(String id) {
        super(id);
    }

    @Override
    public void printPlayerInfo() {
        System.out.println("-------------------------------");
        System.out.println("--玩    家: " + id);
        System.out.println("--手    牌: " + hand);
        System.out.println("--點    數: " + getCurrentPoints());
        System.out.println("--本局下注: " + currentBet);
        System.out.println("--全部注碼: " + totalPoints);
        System.out.println("--狀    態: " + playerType.getDescription());
    }
}