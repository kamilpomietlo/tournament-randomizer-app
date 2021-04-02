package com.kamilpomietlo.tournamentrandomizerapp.bootstrap;

import com.kamilpomietlo.tournamentrandomizerapp.model.Army;
import com.kamilpomietlo.tournamentrandomizerapp.repositories.ArmyRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ArmyRepository armyRepository;

    public Bootstrap(ArmyRepository armyRepository) {
        this.armyRepository = armyRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadArmies();
    }

    private void loadArmies() {
        String[] armies = {
                "Moloch", "Borgo", "Hegemony", "Outpost", "Mephisto", "Steel Police", "New York", "Neojungle", "Dancer",
                "Sharrash", "Vegas", "Smart", "Missisipi", "Uranopolis", "Death Breath", "Iron Gang", "Sand Runners",
                // "Troglodytes", "Beasts"
        };

        for (String s : armies) {
            Army army = new Army(s);
            armyRepository.save(army);
        }
    }
}
