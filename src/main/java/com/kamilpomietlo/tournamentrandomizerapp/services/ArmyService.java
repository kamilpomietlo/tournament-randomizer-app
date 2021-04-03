package com.kamilpomietlo.tournamentrandomizerapp.services;

import com.kamilpomietlo.tournamentrandomizerapp.model.Army;
import com.kamilpomietlo.tournamentrandomizerapp.repositories.ArmyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmyService {

    private final ArmyRepository armyRepository;
    private final List<Army> randomizedArmies = new ArrayList<>();

    public ArmyService(ArmyRepository armyRepository) {
        this.armyRepository = armyRepository;
    }

    private List<Army> getArmies() {
        return armyRepository.findAll();
    }

    public List<Army> randomizeArmies() {
        List<Army> armies = getArmies();
        int allArmiesCount = armies.size();
        randomizedArmies.clear();

        for (int i = 0; i < 8; i++) {
            int randomIndex = (int) (Math.random() * allArmiesCount);
            Army randomizedArmy = armies.get(randomIndex);
            randomizedArmies.add(randomizedArmy);

            armies.remove(randomIndex);
            allArmiesCount--;
        }

        return randomizedArmies;
    }

    public List<Army> getRandomizedArmies() {
        return randomizedArmies;
    }
}
