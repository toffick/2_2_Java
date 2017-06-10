package Test.WaitNotify;
// Класс Магазин, хранящий произведенные товары
class StoreMMM{
    private int product=0;
    private boolean available = false;
    public synchronized void get() {
        while (product<1) {
            try { wait(); }
            catch (InterruptedException e) { }
        }
        product--;
        System.out.println("Россия купила 1 трактор");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
    public synchronized void put() {
        while (product>=3) {
            try { wait(); }
            catch (InterruptedException e) { }
        }
        product++;
        System.out.println("МАЗ добавил 1 трактор");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
