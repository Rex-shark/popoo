package com.example.servicepopoo.enums;

import lombok.Getter;

/**
 * 玩家狀態枚舉，表示玩家在遊戲中的不同狀態。
 */
@Getter
public enum PlayerType {

    NEW("新加入", 1),
    WAITING("等待中", 2),
    IN_GAME("遊戲中", 3),
    BUSTED("爆點", 4),
    WINNER("已獲勝", 5),
    EXITED("已退出", 6);

    private final String description;
    private final int code;

    PlayerType(String description, int code) {
        this.description = description;
        this.code = code;
    }
}
