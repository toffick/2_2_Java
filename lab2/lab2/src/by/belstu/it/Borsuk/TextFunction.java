package by.belstu.it.Borsuk;

//koko
import static java.lang.System.out;

public class TextFunction implements TextFunctionnew {
    public TextFunction() {
        out.print("Cosructor");
    }

    private int l;

    @Override
    public int getL() {
        return l;
    }

    @Override
    public String toString() {
        return "TextFunction{}";
    }

    public String getValueh() {
        SetL();
        return "Hello world from first project";
    }

    private void SetL() {
        String l = "d";

        for (int i=0; i<9; i++) {
            if (i > -1 && i < 10) System.out.println(i);
        }

    }

        public void Loop()
        {
            for (int p = 0; p < 10; p++) {

            }
        }


}

