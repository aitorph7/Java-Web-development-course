package com.certidevs.bucles_while;

import java.util.Scanner;

public class BucleDoWhile {

    public static void main(String[] args) {

        String password = "admin";
        Scanner scanner = new Scanner(System.in);
        String userPassword;
        do {
            System.out.println("Introduce tu password: ");
            userPassword = scanner.nextLine();

        } while (mismatchPasswords(userPassword, password));
    }

    private static boolean mismatchPasswords(String userPassword, String password) {
        return !userPassword.equals(password);
    }
}
