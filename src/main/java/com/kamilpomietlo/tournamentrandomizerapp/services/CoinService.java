package com.kamilpomietlo.tournamentrandomizerapp.services;

import com.kamilpomietlo.tournamentrandomizerapp.model.Coin;
import org.springframework.stereotype.Service;

@Service
public class CoinService {

    public String flipCoin() {
        int randomNumber = (int) (Math.random() * 2);

        return Coin.values()[randomNumber].toString();
    }
}
