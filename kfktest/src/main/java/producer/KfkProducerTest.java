package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Create by zhaolulu on 2019/11/1 23:15
 */
public class KfkProducerTest {


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.17.1:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        for (int i = 0; i < 100 ; i++) {
            producer.send(new ProducerRecord<String, String>("test",String.valueOf(i),String.valueOf(i)));
        }

        producer.close();

    }
}
