package com.lordgasmic.feedingservice.controller;

import com.lordgasmic.feedingservice.model.FeedRequest;
import com.lordgasmic.feedingservice.model.FeedResponse;
import com.lordgasmic.feedingservice.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedingController {

    @Autowired
    private FeedingService service;

    @PutMapping("/api/v1/feed")
    public void feeding(@RequestBody final FeedRequest request) {
        service.putFeed(request);
    }

    @PutMapping("/api/v1/feeds")
    public void feedings(@RequestBody final List<FeedRequest> requests) {
        service.putFeeds(requests);
    }

    @GetMapping("/api/v1/feeds")
    public List<FeedResponse> feeds() {
        return service.getFeeds();
    }
}
