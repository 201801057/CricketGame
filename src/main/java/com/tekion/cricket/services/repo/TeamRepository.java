package com.tekion.cricket.services.repo;

import com.tekion.cricket.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamRepository extends MongoRepository<Team, String> {

}
