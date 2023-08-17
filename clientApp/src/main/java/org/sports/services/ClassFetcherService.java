package org.sports.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sports.kafka.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassFetcherService {

    @Autowired private Consumer consumer;

    private final static Logger logger = LoggerFactory.getLogger(ClassFetcherService.class);

    public String getEvent() {
        try{
            consumer.getEvent();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "fail";

        }
        return "success";
    }

}
