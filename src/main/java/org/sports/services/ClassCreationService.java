package org.sports.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sports.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassCreationService {

    @Autowired private Producer producer;

    private final static Logger logger = LoggerFactory.getLogger(ClassCreationService.class);

    public String createClass() {
        try{
            producer.emitEvent();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "fail";

        }
        return "success";
    }

}
