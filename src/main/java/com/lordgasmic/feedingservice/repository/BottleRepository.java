package com.lordgasmic.feedingservice.repository;

import com.lordgasmic.feedingservice.entity.BottleEntity;
import com.lordgasmic.feedingservice.entity.BottleEntityPK;
import org.springframework.data.repository.CrudRepository;

public interface BottleRepository extends CrudRepository<BottleEntity, BottleEntityPK> {
}
