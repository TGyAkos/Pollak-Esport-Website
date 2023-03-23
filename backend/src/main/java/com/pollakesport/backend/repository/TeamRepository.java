package com.pollakesport.backend.repository;

import com.pollakesport.backend.domain_model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeamRepository extends CrudRepository<Team, UUID> {
}
