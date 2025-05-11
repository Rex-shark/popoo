package com.example.servicepopoo.model;

import com.example.servicepopoo.enums.PlayerType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Player {

    protected String id; // 玩家 ID
    protected int totalPoints; // 玩家總注碼
    protected List<Poker> hand; // 玩家目前手牌
    protected PlayerType playerType; // 玩家狀態

    public Player(String id) {
        this.id = id;
        this.hand = new ArrayList<>();
        this.totalPoints = 0; // 初始總注碼為 0
        this.playerType = PlayerType.NEW; // 初始狀態為新加入
    }

    /**
     * 新增一張牌到玩家手牌
     *
     * @param poker 要加入的撲克牌
     */
    public void addCardToHand(Poker poker) {
        hand.add(poker);
    }

    /**
     * 計算玩家目前手牌的總點數。
     *
     * @return 玩家手牌的總點數
     */
    public double getCurrentPoints() {
        double totalPoints = 0;
        for (Poker card : hand) {
            int point = card.getPoint();
            if (point == 1) {
                totalPoints += 1; // A 的點數固定為 1
            } else if (point >= 11 && point <= 13) {
                totalPoints += 0.5; // J/Q/K 的點數
            } else {
                totalPoints += point; // 其他牌的點數
            }
        }
        return totalPoints;
    }

    /**
     * 印出玩家資訊
     */
    public abstract void printPlayerInfo();
}