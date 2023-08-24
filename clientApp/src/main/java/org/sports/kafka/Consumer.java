package org.sports.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private KafkaConsumer<String, String> kafkaConsumer;

    public String getEvent() {

        ConsumerRecords<String, String> records =
                    kafkaConsumer.poll(Duration.ofMillis(10000));

        StringBuilder result = new StringBuilder();

            for (ConsumerRecord<String, String> record : records){
                log.info("Key: " + record.key() + ", Value: " + record.value());
                log.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                result.append(record.value());
            }
        return result.toString();
    }
}
