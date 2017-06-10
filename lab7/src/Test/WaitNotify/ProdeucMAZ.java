package Test.WaitNotify;

/**
 * Created by DELL on 31.03.2017.
 */
// класс Производитель
class ProducerMAZ extends Thread{
    StoreMMM store;
    ProducerMAZ(StoreMMM store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {

            store.put();


        }
    }
}
// Класс Потребитель
class ConsumerRUSSIA extends Thread{
    StoreMMM store;
    ConsumerRUSSIA(StoreMMM store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 8; i++) {
            store.get();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}