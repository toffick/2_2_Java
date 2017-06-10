package Test.WaitNotify;

/**
 * Created by DELL on 31.03.2017.
 */
public class main {


    public static void main(String[] args) {
        StoreMMM store=new StoreMMM();
        ProducerMAZ producer = new ProducerMAZ(store);
        ConsumerRUSSIA consumer = new ConsumerRUSSIA(store);
        producer.start();
        consumer.start();
    }

}
