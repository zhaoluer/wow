package producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;

import java.util.Properties;

/**
 * Create by zhaolulu on 2019/11/3 21:51
 */
public class KfkProducerFullNonBlocking {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.17.1:9092");
        props.put("acks", "all");
        props.put("transactional.id","my-transactional.id");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.initTransactions();
        try {
            producer.beginTransaction();
            for (int i = 0; i < 100; i++)
                producer.send(new ProducerRecord<>("my-topic", Integer.toString(i), Integer.toString(i)), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        //这个函数在请求完成时候被调用
                        /**
                         * 当用作事务的一部分时，不必为了检测发送中的错误而定义回调或检查将来的结果。
                         * 如果任何发送调用失败并出现不可恢复的错误，则最后的commitTransaction（）
                         * 调用将失败，并从上次失败的发送中引发异常。 发生这种情况时，您的应用程序应
                         * 调用abortTransaction（）以重置状态并继续发送数据。
                         *
                         *
                         *
                         * 启用幂等但未配置transactional.id时，情况与此类似。 在这种情况下，
                         * UnsupportedVersionException和AuthorizationException被视为致命错误。 但是，
                         * 无需处理ProducerFencedException。 此外，可以在收到OutOfOrderSequenceException
                         * 之后继续发送，但是这样做可能导致挂起的消息的发送顺序混乱。 为了确保正确的订购，
                         * 您应该关闭生产者并创建一个新实例。
                         */
                        if (e==null){
                            System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
                        }else {
                            //异常情况下做一些处理
                            e.printStackTrace();
                        }
                    }
                });
            producer.commitTransaction();
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            // We can't recover from these exceptions, so our only option is to close the producer and exit.
            producer.close();
        } catch (KafkaException e) {
            // For all other exceptions, just abort the transaction and try again.
            producer.abortTransaction();
        }
        producer.close();
    }
}
