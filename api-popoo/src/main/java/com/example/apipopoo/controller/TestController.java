package com.example.apipopoo.controller;

import com.example.servicepopoo.model.Banker;
import com.example.servicepopoo.model.Gamer;
import com.example.servicepopoo.model.Room;
import com.example.servicepopoo.utils.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("demo")
    @ResponseBody
    public ResponseEntity<?> demo()  {
        System.out.println("demo");
        HttpServletRequest request = CommonUtils.getRequest();
        System.out.println("request " + request.getRequestURI());

        Banker banker = new Banker("Banker-1");
        Room room = new Room("Room-1", banker, "Demo Room");

        // 添加玩家
        Gamer gamer1 = new Gamer("gamer1");
        Gamer gamer2 = new Gamer("gamer2");
        room.addPlayer(gamer1);
        room.addPlayer(gamer2);

        // 玩家下注
        room.placeBet(gamer1.getId(), 100);
        room.placeBet(gamer2.getId(), 200);

        System.out.println("玩家下注完成");

        // 開始新一局
        room.startNewRound();
        System.out.println("新一局開始");
        // 顯示莊家手牌
        banker.printPlayerInfo();
        // 顯示每位玩家的手牌
        for (Gamer gamer : room.getGamers()) {
            gamer.printPlayerInfo();
        }

        //發牌給玩家1
        room.dealCardsToGamerById(gamer1.getId());
        gamer1.printPlayerInfo();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
