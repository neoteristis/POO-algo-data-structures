package fr.epu.bicycle;

import fr.epu.bicycle.EBike;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EBike e1= new EBike();
        final String STOP = "s";
        String stop = "f";
        Scanner keyboard = new Scanner(System.in);
        keyboard.useLocale(Locale.US);//To read the doubles with . and not ,

        while (! STOP.equals(stop)) {
            System.out.print("\t What distance did you travel in km or miles ? ");
            if (keyboard.hasNextDouble()) {
                double newDistance = keyboard.nextDouble();//reading a double
                keyboard.nextLine();
                e1.addKm(newDistance);
                System.out.println("\t Your bike has therefore travelled " + e1.getKm() + " km");
            }
            else {
                System.out.println("\t a number is expected for example  1 or 1.5 " );
            }
            System.out.print("Do you want to continue or stop ("+ STOP + ") ? ");
            stop = keyboard.nextLine();
        }
    }
}
