package com.lordgasmic.feedingservice.repository;

import com.lordgasmic.feedingservice.entity.BottleEntity;
import com.lordgasmic.feedingservice.entity.BottleEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface BottleRepository extends CrudRepository<BottleEntity, BottleEntityPK> {

    List<BottleEntity> findByTimestmp(ZonedDateTime timestmp);
}
