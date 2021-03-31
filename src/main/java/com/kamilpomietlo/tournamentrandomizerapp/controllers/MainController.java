package com.kamilpomietlo.tournamentrandomizerapp.controllers;

import com.kamilpomietlo.tournamentrandomizerapp.services.ArmyService;
import com.kamilpomietlo.tournamentrandomizerapp.services.CoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class MainController {

    private final ArmyService armyService;
    private final CoinService coinService;

    public MainController(ArmyService armyService, CoinService coinService) {
        this.armyService = armyService;
        this.coinService = coinService;
    }

    @GetMapping("")
    public String getIndexPage(Model model) {
        model.addAttribute("armies", new ArrayList<>());

        return "index";
    }

    @PostMapping("")
    public String postIndexPage(Model model) {
        model.addAttribute("armies", armyService.getRandomArmyList());

        return "index";
    }

    @GetMapping("coinflip")
    public String getCoinFlip(Model model) {
        model.addAttribute("coin", coinService.flipCoin());

        return "coinflip";
    }
}
