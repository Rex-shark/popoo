package com.example.servicepopoo.model;

import com.example.servicepopoo.enums.PokerType;
import lombok.Getter;

@Getter
public class Poker {

    private int point;


    private PokerType pokerType;


    public Poker(int point, PokerType pokerType) {
        this.point = point;
        this.pokerType = pokerType;
    }


    @Override
    public String toString() {
        return pokerType.getName() + " " + getPointString();
    }

    /**
     * 轉換數字點數為撲克牌標準表示
     */
    private String getPointString() {
        return switch (point) {
            case 1 -> "A";
            case 10 -> "T";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(point);
        };
    }

}
