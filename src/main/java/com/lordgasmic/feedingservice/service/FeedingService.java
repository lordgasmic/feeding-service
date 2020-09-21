package com.lordgasmic.feedingservice.service;

import com.lordgasmic.feedingservice.model.FeedRequest;
import com.lordgasmic.feedingservice.repository.BottleRepository;
import com.lordgasmic.feedingservice.utils.Mapper;
import com.lordgasmic.feedingservice.model.FeedResponse;
import com.lordgasmic.feedingservice.repository.FeedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingService {

    @Autowired
    private FeedingRepository feedingRepository;

    @Autowired
    private BottleRepository bottleRepository;

    public void putFeed(FeedRequest request) {
        feedingRepository.save(Mapper.toFeedingEntity(request));
        Mapper.toBottleEntity(request).stream().forEach(bottleRepository::save);
    }

    public void putFeeds(List<FeedRequest> requests) {
        requests.forEach(this::putFeed);
    }

    public List<FeedResponse> getFeeds() {
//        repository;
        return null;
    }
}
