package org.sports.kafka;

import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(topics = "demo_java", groupId = "foo")
public class ClassEvent {
}
