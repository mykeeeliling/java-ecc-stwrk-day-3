package com.homework.one;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int dimensionsRow = 0;
    static int dimensionsCol = 0;
    static int choice = 0;
    static final int MAX_CHAR_CODE = 126;
    static final int MIN_CHAR_CODE = 33;
    static String[][] randChar = new String[10][10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            // choices
            System.out.println("[1] - Generate Table");
            System.out.println("[2] - Search Table for Character");
            System.out.println("[3] - Replace a character in the table");
            System.out.println("[4] - Reset the table");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //generate table
                    generateTable();
                    break;

                case 2:
                    //search character occurrences
                    System.out.print("Enter character to search: ");
                    String searchCharacter = scanner.next();
                    int charCtr = 0;
                    for (int i = 0; i < dimensionsRow; i++) {
                        for (int j = 0; j < dimensionsCol; j++) {
                            if (randChar[i][j].contains(searchCharacter)) {
                                System.out.println("\n[ " + i + ", " + j + "] - " + (++charCtr) + " Occurrences\n");
                            }
                        }
                    }
                    break;

                case 3:
                    // change cell content
                    //ask for user input which index will be change
                    System.out.print("What Row: ");
                    int changeRow = scanner.nextInt();
                    System.out.print("What Column: ");
                    int changeCol = scanner.nextInt();

                    System.out.print("Enter 3 characters: ");
                    String newChar = scanner.next();
                    if (newChar.length() > 3) {
                        System.out.println("input 3 characters only!");
                        break;
                    } else {
                        randChar[changeRow][changeCol] = newChar;
                    }
                    System.out.println("\n");
                    for (int i = 0; i < dimensionsRow; i++) {
                        for (int j = 0; j < dimensionsCol; j++) {
                            System.out.print(randChar[i][j] + " ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 4:
                    // reset the table
                    generateTable();

            }
        } while (choice != 5);
    }

    public static void generateTable(){
        //generate table
        System.out.print("Enter Row Dimensions: ");
        dimensionsRow = scanner.nextInt();
        System.out.print("Enter Column Dimensions: ");
        dimensionsCol = scanner.nextInt();
        for (int i = 0 ; i < dimensionsRow; i++) {
            for (int j = 0; j < dimensionsCol; j++) {
                Random randString = new Random();
                StringBuilder randS = new StringBuilder("");
                int k = 0;
                while (k < 3) {
                    int ascii = randString.nextInt((MAX_CHAR_CODE - MIN_CHAR_CODE) + 1) + MIN_CHAR_CODE;
                    randS.append((char)(ascii));
                    k++;
                }
                String rand = randS.toString();
                randChar[i][j] = rand;
            }
        }
        System.out.println("\n");
        for (int i = 0 ; i < dimensionsRow; i++){
            for (int j = 0; j < dimensionsCol; j++){
                System.out.print(randChar[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
