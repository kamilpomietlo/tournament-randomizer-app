package com.kamilpomietlo.tournamentrandomizerapp.repositories;

import com.kamilpomietlo.tournamentrandomizerapp.model.Army;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmyRepository extends JpaRepository<Army, Long> {
}
