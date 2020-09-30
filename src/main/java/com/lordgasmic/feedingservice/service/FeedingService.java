package com.lordgasmic.feedingservice.service;

import com.lordgasmic.feedingservice.entity.FeedingEntity;
import com.lordgasmic.feedingservice.model.FeedRequest;
import com.lordgasmic.feedingservice.model.FeedResponse;
import com.lordgasmic.feedingservice.repository.BottleRepository;
import com.lordgasmic.feedingservice.repository.FeedingRepository;
import com.lordgasmic.feedingservice.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        Iterable<FeedingEntity> entities = feedingRepository.findAll();

        return StreamSupport.stream(entities.spliterator(), false).map(Mapper::toFeedResponse).collect(Collectors.toList());
    }
}
