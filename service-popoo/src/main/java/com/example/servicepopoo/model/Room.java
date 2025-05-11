package com.example.servicepopoo.model;

import lombok.Data;

import com.example.servicepopoo.enums.PlayerType;

import java.util.ArrayList;
import java.util.List;

/**
 * 房間類別，代表一個撲克牌遊戲的房間。
 * 包含房間 ID、玩家名單與撲克牌牌堆。
 */
@Data
public class Room {

    private String id; // 房間 ID
    private Banker banker; // 莊家
    private String name; // 房間名稱
    private List<Gamer> gamers; // 玩家名單
    private Deck deck; // 撲克牌牌堆

    public Room(String id, Banker banker, String name) {
        this.id = id;
        this.banker = banker;
        this.name = name;
        this.gamers = new ArrayList<>();
        this.deck = Deck.initDeck(); // 初始化牌堆
    }
    /**
     * 開啟新牌局，為每位玩家和莊家各發一張牌
     */
    public void startNewRound() {
        // 為每位玩家發一張牌
        for (Player player : gamers) {
            player.addCardToHand(deck.draw());
        }
        // 為莊家發一張牌
        if (banker != null) {
            banker.addCardToHand(deck.draw());
        } else {
            System.out.println("莊家不存在！");
        }
    }

    /**
     * 發牌給指定的玩家
     *
     * @param gamerId 玩家 ID
     */
    public void dealCardsToGamerById(String gamerId) {
        for (Gamer gamer : gamers) {
            if (gamer.getId().equals(gamerId)) {
                gamer.addCardToHand(deck.draw());
                return;
            }
        }
        System.out.println("未找到玩家 " + gamerId + "！");
    }

    /**
     * 發牌給莊家
     */
    public void dealCardsToBanker() {
        if (banker != null) {
            banker.addCardToHand(deck.draw());
        } else {
            System.out.println("莊家不存在！");
        }
    }

    /**
     * 玩家下注
     *
     * @param playerId 玩家 ID
     * @param betAmount 下注金額
     * @return 是否成功下注
     */
    public boolean placeBet(String playerId, int betAmount) {
        for (Gamer gamer : gamers) {
            if (gamer.getId().equals(playerId)) {
                gamer.setCurrentBet(betAmount);
                gamer.setPlayerType(PlayerType.WAITING); // 設定玩家狀態為等待中
                return true;
            }
        }
        System.out.println("未找到玩家 " + playerId + "！");
        return false;
    }

    /**
     * 新增玩家到房間
     *
     * @param gamer 要加入的玩家
     */
    public void addPlayer(Gamer gamer) {
        gamers.add(gamer);
    }

    /**
     * 從房間移除玩家
     *
     * @param playerId 要移除的玩家 ID
     * @return 是否成功移除
     */
    public boolean removePlayer(String playerId) {
        return gamers.removeIf(player -> player.getId().equals(playerId));
    }
}