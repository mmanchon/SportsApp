package org.sports.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired private KafkaProducer<String, String> kafkaProducer;
    private int counter = 0;

    public void emitEvent() {
        String topic = "demo_java";
        String value = "hello world " + Integer.toString(counter);
        String key = "id_" + Integer.toString(counter);

        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(topic, key, value);

        kafkaProducer.send(producerRecord, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                // executes every time a record is successfully sent or an exception is thrown
                if (e == null) {
                    // the record was successfully sent
                    log.info("Received new metadata. \n" +
                            "Topic:" + recordMetadata.topic() + "\n" +
                            "Key:" + producerRecord.key() + "\n" +
                            "Partition: " + recordMetadata.partition() + "\n" +
                            "Offset: " + recordMetadata.offset() + "\n" +
                            "Timestamp: " + recordMetadata.timestamp());
                } else {
                    log.error("Error while producing", e);
                }
            }
        });

        // flush data - synchronous
        kafkaProducer.flush();

        // flush and close producer
        kafkaProducer.close();
    }
}
