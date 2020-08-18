package com.lordgasmic.feedingservice.repository;

import com.lordgasmic.feedingservice.entity.UserEntity;
import org.springframework.data.repository.Repository;

public interface LoginRepository extends Repository<UserEntity, String> {

    void save(UserEntity entity);
}
