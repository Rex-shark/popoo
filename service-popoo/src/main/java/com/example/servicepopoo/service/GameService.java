package com.example.servicepopoo.service;

import com.example.servicepopoo.model.Deck;
import com.example.servicepopoo.model.Poker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * GameService 提供撲克牌遊戲「10點半」的核心邏輯。
 * 包括發牌、計算點數、判斷是否爆牌等功能。
 */
@Service
public class GameService {

    private Deck deck; // 撲克牌牌堆
    private List<Poker> playerHand; // 玩家手牌

    /**
     * 建構子，初始化牌堆與玩家手牌。
     */
    public GameService() {
        this.deck = Deck.initDeck(); // 初始化牌堆
        this.playerHand = new ArrayList<>(); // 初始化玩家手牌
    }

    /**
     * 抽一張牌並加入玩家手牌。
     *
     * @return 抽到的撲克牌
     */
    public Poker drawCard() {
        Poker card = deck.draw(); // 從牌堆抽一張牌
        playerHand.add(card); // 將牌加入玩家手牌
        return card;
    }

    /**
     * 計算玩家手牌的總點數。
     * A 的點數固定為 1，J/Q/K 的點數為 0.5。
     *
     * @return 玩家手牌的總點數
     */
    public double calculatePoints() {
        double total = 0;
        for (Poker card : playerHand) {
            int point = card.getPoint();
            if (point == 1) {
                total += 1; // A 的點數固定為 1
            } else if (point >= 11 && point <= 13) {
                total += 0.5; // J/Q/K 的點數
            } else {
                total += point; // 其他牌的點數
            }
        }
        return total;
    }

    /**
     * 判斷玩家是否爆牌（點數超過 10.5）。
     *
     * @return 如果玩家爆牌則回傳 true，否則回傳 false
     */
    public boolean isBust() {
        return calculatePoints() > 10.5;
    }

    /**
     * 獲取玩家的手牌列表。
     *
     * @return 玩家手牌的列表
     */
    public List<Poker> getPlayerHand() {
        return playerHand;
    }
}