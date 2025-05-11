package com.example.servicepopoo.enums;

import lombok.Getter;

@Getter
public enum PokerType {

        SPADE("♠", 1),
        HEART("♥", 2),
        CLUB("♣", 3),
        DIAMOND("♦", 4),
        UNKNOWN("?", 0);

        private final String name;
        private final int code;

        PokerType(String name, int code) {
                this.name = name;
                this.code = code;
        }
}
