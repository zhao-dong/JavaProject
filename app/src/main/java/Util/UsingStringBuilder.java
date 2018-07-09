package Util;

/**
 * Created by dong.zhao on 2017/9/30.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;


class Candy {
    static { System.out.println("Loading Candy");}
}

class Gum {
    static { System.out.println("Loading Gum");}
}

class Cookie {
    static { System.out.println("Loading Cookie");}
}


class Initable {
    static {

        System.out.println("Initalizing Initable");

    }

    Initable() { System.out.println("In construction function");}

    static final int staticFinal =47;
    static  int staticFinal2 = 258;
}


class Initable2 {
    static int staticNonfinal = 148;
    static {
        System.out.println("Initializing Initable2");
    }
}

public class UsingStringBuilder {
    public static Random rand = new Random(47);
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < 25; i++)
        {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("]");
        return result.toString();
    }



    public static void main(String[] args)
    {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
        int x = 5;
        double y = 5.33332542;
        System.out.printf("Row 1: [%d, %f]\n", x,y);

        PrintStream outAlias = System.out;
        Formatter f = new Formatter(outAlias);
        f.format("%s The turtle is at (%d,%d)\n", "tommy", 100,101);
        String str = String.format("%s the turtle is at (%d, %d)\n","hello", 120,121);
        outAlias.println(str);

        BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));
        try {
            String name = input.readLine();
            System.out.println(name);

            String number = input.readLine();
            String[] numArray = number.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.format("Hi %s. \n",name);
            System.out.format("In 5 years you will be %d.\n", age);
            System.out.format("My favoriate double is %f.\n", favorite);
            String str1 = new String("Sir Robin of Camelot\n22 1.61803");
            System.out.println(str1);
            Scanner scanner = new Scanner(str1);
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextInt());
            System.out.println(scanner.nextDouble());


            Random rand = new Random(47);
            for(int i = 0; i < 25; i++)
            {
                System.out.println(rand.nextInt(100));
            }


            System.out.println("Inside Main");
            new Candy();

            System.out.println("After creating Candy");

            Class c = null;
            try {
                c = Class.forName("Util.Gum");
            } catch (ClassNotFoundException e) {
                System.out.println("Couldn't find Gum");
            }

            System.out.println(c.getSimpleName());
            System.out.println(c.getCanonicalName());



            System.out.println("After Class.forName(\"Gum\")");
            new Cookie();
            System.out.println("After Creating Cookie");

           // Initable it = new Initable();


           // try
            {


                Class initable = Initable.class;
                //Class initable = Class.forName("Util.Initable");
                System.out.println("After creating initable ref");
                System.out.println(Initable.staticFinal);
                System.out.println(Initable.staticFinal2);
            }
            //catch(ClassNotFoundException e) {
             //   e.printStackTrace();
            //}


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}