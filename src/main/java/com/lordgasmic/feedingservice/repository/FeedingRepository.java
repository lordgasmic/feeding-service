package com.lordgasmic.feedingservice.repository;

import com.lordgasmic.feedingservice.entity.FeedingEntity;
import org.springframework.data.repository.CrudRepository;

public interface FeedingRepository extends CrudRepository<FeedingEntity, String> {
}
