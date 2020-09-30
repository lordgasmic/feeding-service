package com.lordgasmic.feedingservice.service;

import com.lordgasmic.feedingservice.entity.BottleEntity;
import com.lordgasmic.feedingservice.entity.FeedingEntity;
import com.lordgasmic.feedingservice.model.FeedRequest;
import com.lordgasmic.feedingservice.model.FeedResponse;
import com.lordgasmic.feedingservice.repository.BottleRepository;
import com.lordgasmic.feedingservice.repository.FeedingRepository;
import com.lordgasmic.feedingservice.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
public class FeedingService {

    @Autowired
    private FeedingRepository feedingRepository;

    @Autowired
    private BottleRepository bottleRepository;

    public void putFeed(FeedRequest request) {
        feedingRepository.save(Mapper.toFeedingEntity(request));
        Mapper.toBottleEntity(request).forEach(bottleRepository::save);
    }

    public void putFeeds(List<FeedRequest> requests) {
        requests.forEach(this::putFeed);
    }

    public List<FeedResponse> getFeeds() {
        Iterable<FeedingEntity> entities = feedingRepository.findAll();
        Map<ZonedDateTime, List<BottleEntity>> derp = StreamSupport.stream(entities.spliterator(), false)
                                                        .map(entity -> bottleRepository.findByPkTimestmp(entity.getTimestmp()))
                                                        .flatMap(Collection::stream)
                                                        .collect(Collectors.groupingBy(bottleEntity -> bottleEntity.getPk().getTimestmp()));

        List<FeedResponse> responses = derp.entrySet()
                                           .stream()
                                           .map(entry -> Mapper.toFeedResponse(entry.getKey(), entry.getValue()))
                                           .collect(toList());
        return responses;
    }
}
