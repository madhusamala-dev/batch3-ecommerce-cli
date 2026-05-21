package com.stschool.ecommerce.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String message){
        System.out.println(message);
        return scanner.nextInt();
    }
    public static float getFloatInput(String message){
        System.out.println(message);
        return scanner.nextFloat();
    }
    public static double getDoubleInput(String message){
        System.out.println(message);
        return scanner.nextDouble();
    }
    public static String getStringInput(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void closeScanner(){
        scanner.close();
    }
}
