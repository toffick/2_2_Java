package by.belstu.it.Borsuk.basejava;
import static java.lang.Math.*;
/**
 * Created by ACER on 05.02.2017.
 */

import java.util.Arrays;
import  java.util.Random;
import java.util.Scanner;

public class JavaTest {
    /**{@value #L} КОКОКОКО!!!11*/
    public static  int sint;
        final int F = 5;
        public final int H = 6;
        public static final int L = 7;
    /**
        *@param args - массив строк /main function
         *@see  JavaTest#sint          */



        public static void main(String[] args) {

                        char _char = 'c';
                        String _string = "string";
                        int _int = 100;
                        short _short = 30;
                        byte _byte = 10;
                        long _long = 100000L;
                        boolean _bool = true;
                        double _double = 10.5;

                        System.out.println(_string+_int);
                        System.out.println(_string+_char);
                        System.out.println(_string+_double);

                        _byte =(byte)(_byte + _int);
                        System.out.println(_byte);
                        _int = (int) (_double + _long);
                        System.out.println(_int);
                        _long = _int + (long) 2147483647;
                        System.out.println(_long);


                        System.out.println(sint);
                        _bool = true && false;
                        System.out.println(_bool);
                        _bool = true ^ false;
                        System.out.println(_bool);
                        // System.out.println(_bool+_bool);
                        long maxval = 9223372036854775807L;
                        long maxval2 = 0x7fff_ffff_fffL;


                        char a = 'a', b = '\u0061', c = 97;
                        System.out.printf("%c, %c, %c ", a, b, c);
                        System.out.println((char) (a + b + c));
                        System.out.println(3.45 % 2.4);
                        System.out.println(1.0 / 0.0);
                        System.out.println(0.0 / 0.0);
                        System.out.println(Math.log(-345));
                        System.out.println(Float.intBitsToFloat(0x7F800000));
                        System.out.println(Float.intBitsToFloat(0xFF800000));
                        System.out.println(Math.PI);
                        System.out.println(Math.E);
                        System.out.println(Math.round(Math.PI));
                        System.out.println(Math.round(Math.E));
                        System.out.println(Math.min(Math.PI, Math.E));
                        final Random random = new Random();
                        System.out.println(random.nextInt(1));
//e
                        Boolean _obool = false;
                        Character _ochar = 'c';
                        Integer _oint = 9;
                        Byte _obyte = 5;
                        Short _oshort = 10;
                        Long _olong = 400L;
                        Double _odouble = 10.5;

                        System.out.println("                                    Оболочки");
                        System.out.println(_oint >>1);
                        System.out.println(_obool ^ true);

                        System.out.println(Long.MIN_VALUE);
                        System.out.println(Double.MIN_VALUE);
                        System.out.println(Long.MAX_VALUE);
                        System.out.println(Double.MIN_VALUE);

                        Integer ibox = _int;
                        System.out.println((int) ibox);
                        Byte ibyte = _byte;
                        System.out.println(ibyte);

                        System.out.println(Integer.parseInt("111"));
                        System.out.println(Integer.toHexString(11155));
                        System.out.println(Integer.compare(4, 5));
                        System.out.println(Integer.bitCount((1111111)));


//f
                        String s34 = "2345";
                        System.out.println(Integer.valueOf(s34));
                        System.out.println(Integer.parseInt(s34));

                        Integer string_value = new Integer(s34);
                        System.out.println(string_value);

                        byte[] stringsbyte = s34.getBytes();
                        System.out.println(Arrays.toString(stringsbyte));
                        String news34 = new String(stringsbyte);
                        System.out.println(news34);

                        System.out.println(Boolean.valueOf("true"));
                        System.out.println(Boolean.parseBoolean(s34));

                        System.out.println("\t\t\tСРавнение строк");
                        String s1 = "kolokolokokoko", s2 = "kokokokokoko";
                        System.out.println(s1 == s2);
                        System.out.println(s1.equals(s2));
                        System.out.println(s1.compareTo(s2));
                        s2 = null;
                        System.out.println(s1 == s2);
                        System.out.println(s1.equals(s2));
                        //System.out.println(s1.compareTo(s2));


                        System.out.println();
                       for (String retval : s1.split("lo")) {
                              System.out.println(retval);
                       }

                        System.out.println(s1.contains("ko"));
                        System.out.println(s1.hashCode());
                        System.out.println(s1.indexOf('o'));
                        System.out.println(s1.length());

                        System.out.println(s1.replace('k', 's'));
//g
                        System.out.println();
                        char[][] c1;
                        char[] c2[] = {{'1', '2'}, {'3', '4'}};
                        char c3[][] = {{'a', 'b'}, {'c', 'd'}};
                        char[] ss = new char[0];
                  //    ss[0]='s';
                        c1 = new char[3][];
                        for (int i = 0, j = 2; i < 3; i++, j++)
                                c1[i] = new char[j];

                        System.out.println(c1.length);
                        System.out.println(c1[0].length);
                        System.out.println(c1[1].length);
                        System.out.println(c1[2].length);

                        System.out.println(c2 == c3);

                        for (char[] i : c2) {
                                for (char t : i) {
                                        System.out.printf("%c\t", t);
                                }
                                System.out.println();
                        }

                        // c1[2][4]= 'd';                            //исключение


//h
                          System.out.println('\n');
                        WrapperString WrapperStringobj = new WrapperString("hello world");

                          WrapperStringobj.replace('l','4');

                         System.out.println(WrapperStringobj.getStr());
/** использование анонимного класса*/
                WrapperString kkk = new WrapperString("test anon class"){
                        //@Override
                        public void replace (char oldchar, char newchar)
                        {
                                this.setStr(this.getStr().replace(oldchar,newchar));
                                System.out.println("Work of anon. class");
                                System.out.println(delete());
                        }
/**@return Возвращает строку*/
                        public  String delete()
                        {
                                return "Work of anon. class -> delete method ";
                        }
                };

                kkk.replace('s', '-');
                System.out.println(kkk.getStr());
         //   Scanner koko = new Scanner(System.in);
                }




}
