package Test.SynchronizedTest;

import java.io.FileWriter;
import java.io.IOException;

class ResourceObj {
    private FileWriter slkad;

    public ResourceObj(String file) throws IOException {
// проверка наличия файла
        slkad = new FileWriter(file, true);
    }

    public synchronized void dumping(String str, int i) {
        try {
            slkad.append(str);
            System.out.print(str);
            Thread.sleep((long) (Math.random() * 50));
            slkad.append("->" + i + " товар выгружен ");
            System.out.println("->" + i + " товар выгружен ");
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        }
    }

    public void close() {
        try {
            slkad.close();
        } catch (IOException e) {
            System.err.print("ошибка закрытия файла: " + e);
        }
    }
}