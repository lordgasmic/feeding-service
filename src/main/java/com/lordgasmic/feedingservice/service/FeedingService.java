package com.lordgasmic.feedingservice.service;

import com.lordgasmic.feedingservice.utils.Mapper;
import com.lordgasmic.feedingservice.model.FeedRequest;
import com.lordgasmic.feedingservice.model.FeedResponse;
import com.lordgasmic.feedingservice.repository.FeedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingService {

    @Autowired
    private FeedingRepository repository;

    public void putFeed(FeedRequest request) {
        repository.save(Mapper.toEntity(request));
    }

    public List<FeedResponse> getFeeds() {
//        repository;
        return null;
    }
}
