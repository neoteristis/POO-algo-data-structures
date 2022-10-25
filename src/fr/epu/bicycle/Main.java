package fr.epu.bicycle;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    public static double milesToKm(double miles) {
        return miles * 1.609344;
    }

    static void evaluateTime4around(){
        Fleet oneFleet = new Fleet();
        long totalTime =0;
        Position currentPosition = new Position(7, 7);
        for (int i = 0; i<1000; i++) {
            long startTime = System.nanoTime();
            oneFleet.around(currentPosition, 10);
            long endTime = System.nanoTime();
            long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
            totalTime += durationInNano;
        }
        System.out.println("total time in nano : " + totalTime);
        System.out.println("total time in milli : " + TimeUnit.NANOSECONDS.toMillis(totalTime));
    }

    public static void main(String[] args) {

        evaluateTime4around();

        EBike e1= new EBike();
        final String STOP = "s";
        String stop = "f";
        Scanner keyboard = new Scanner(System.in);
        keyboard.useLocale(Locale.US); // To read the doubles with . and not ,

        while (! STOP.equals(stop)) {
            System.out.print("\t What distance did you travel in km or miles ? ");
            if (keyboard.hasNextLine()) {
                String input = keyboard.nextLine();// reading a double

                String value = input.split(" ")[0];
                String unit = input.split(" ")[1].trim();

                double newDistance;
                if (Objects.equals(unit, "mi")) {
                    newDistance = milesToKm(Double.parseDouble(value));
                } else {
                    newDistance = Double.parseDouble(value);
                }

                e1.addKm(newDistance);
                System.out.println("\t Your bike has therefore travelled " + e1.getKm() + " km" + " or " + kmToMiles(e1.getKm()) + "mi");
            }
            System.out.print("Do you want to continue or stop ("+ STOP + ") ? ");
            stop = keyboard.nextLine();
        }
    }
}
