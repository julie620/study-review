/*
 * Author: Juliana Serrano
 * Last Modified: 03/07/2025
 * Lab 6: Hashing
 * The ASCII class contains methods to create ASCII word art
 * The letter and letter-space combos from previous project
 * AVAILABLE LETTERS: A, D, E, I, M, N, O, R, S, T, U, Y
*/

public class ASCII {

    //PRINTS SPACES X AMOUNT OF TIMES
    public void space(int number) {
        for (int i = number; i > 0; i--) {
            System.out.print(" ");
        }
    }

    //PRINTS LETTERS X AMOUNT OF TIMES
    public void letters(String letter, int number) {
        for (int i = number; i > 0; i--) {
            System.out.print(letter);
        }
    }

    //PRINTS A LETTER SPACE LETTER COMBO (LETTER AMOUNTS ARE THE SAME)
    public void lSL(String letter, int letterNum, int spaceNum) {
        letters(letter, letterNum); 
        space(spaceNum);
        letters(letter, letterNum);
    }

    //PRINTS A LETTER SPACE DIFFERENT AMOUNT LETTER COMBO 
    public void lSDL(String letter, int LettNumOne, int spaceNum, int LettNumTwo) {
        letters(letter, LettNumOne); 
        space(spaceNum);
        letters(letter, LettNumTwo);
    }

    //PRINTS A LETTER SPACE LETTER SPACE LETTER COMBO (ALL VALUES MAY VARY)
    public void lSLSL(String letter, int lettOne, int spaOne, int lettTwo, int spaTwo) {
        letters(letter, lettOne);
        space(spaOne);
        letters(letter, lettTwo);
        space(spaTwo);
        letters(letter, lettOne);
    }

     //PRINTS A LINE OF TWO LETTERS
     public void twoLine(String letter) {
        letters(letter, 2);
    }

    //PRINTS A LiNE OF SIX LETTERS
    public void sixLine(String letter) {
        letters(letter, 6);
    }

    //PRINTS A LINE OF EIGHT LETTERS
    public void eightLine(String letter) {
        letters(letter, 8);
    }

    //LETTER A
    public void a(int lineNum) {
        switch (lineNum) {
            case 1: 
                space(5);
                letters("A", 1);
                space(8);
                break;
            case 2:
                space(4);
                letters("A", 3);
                space(7);
                break;
            case 3:
                space(3);
                lSL("A", 1, 3);
                space(6);
                break;
            case 4:
                space(2);
                lSL("A", 2, 3);
                space(5);
                break;
            case 5:
                space(1);
                letters("A", 9);
                space(4);
                break;
            case 6:
                lSL("A", 2, 7);
                space(3);
                break;
        }
    }

    //LETTER D
    public void d(int lineNum) {
        switch (lineNum) {
            case 1:
            case 6:
                eightLine("D");
                space(3);
                break;
            case 2:
            case 5:
                lSL("D", 2, 5);
                space(2);
                break;
            case 3:
            case 4:
                lSL("D", 2, 6);
                space(1);
                break;
        }
    }

    //LETTER E
    public void e(int lineNum) {
        switch (lineNum) {
            case 1:
            case 3:
            case 6:
                eightLine("E");
                space(2);
                break;
            case 2:
            case 4:
            case 5:
                twoLine("E");
                space(8);
                break;
        }
    }

    //LETTER I
    public void i() {
        space(4);
        twoLine("I");
        space(4);
    }

    //LETTER M 
    public void m(int lineNum) {
        switch (lineNum) {
            case 1:
                space(5);
                lSL("M", 3, 7);
                space(8);
                break;
            case 2: 
                space(4);
                lSL("M",5, 5);
                space(7);
                break;
            case 3:
                space(3);
                lSL("M", 2, 3);
                space(3);
                lSL("M", 2, 3);
                space(6);
                break;
            case 4:
                space(2);
                lSL("M", 2, 5);
                space(1);
                lSL("M", 2, 5);
                space(5);
                break;
            case 5:
                space(1);
                lSLSL("M", 2, 7, 3, 7);
                space(4);
                break;
            case 6:
                lSL("M", 2, 19);
                space(3);
                break;
        }
    }

    //LETTER N
    public void n(int lineNum) {
        switch (lineNum) {
            case 1:
            case 6:
                lSL("N", 2, 7);
                space(3);
                break;
            case 2:
                lSDL("N", 3, 6, 2);
                space(3);
                break;
            case 3:
                lSLSL("N", 2, 2, 1, 4);
                space(3);
                break;
            case 4:
                lSLSL("N", 2, 4, 1, 2);
                space(3);
                break;
            case 5:
                lSDL("N", 2, 6, 3);
                space(3);
                break;
        }
    }

    //LETTER O
    public void o(int lineNum) {
        switch (lineNum) {
            case 1:
            case 6:
                space(3);
                letters("O", 4);
                space(5);
                break;
            case 2:
            case 5:
                space(1);
                lSL("O", 2, 4);
                space(3);
                break;
            case 3:
            case 4:
                lSL("O", 2, 6);
                space(2);
                break;
        }
    }

    //LETTER R
    public void r(int lineNum) {
        switch (lineNum) {
            case 1:
                eightLine("R");
                space(2);
                break;
            case 2:
                lSL("R", 2, 4);
                space(2);
                break;
            case 3:
                sixLine("R");
                space(4);
                break;
            case 4:
            case 5:
            case 6:
                lSL("R", 2, lineNum);
                space(6 - lineNum);
                break;
        }
    }

    //LETTER S
    public void s(int lineNum) {
        switch (lineNum) {
            case 1:
                space(1);
                eightLine("S");
                space(1);
                break;
            case 2:
                letters("S", 3);
                space(7);
                break;
            case 3:
                space(2);
                letters("S", 3);
                space(5);
                break;
            case 4:
                space(4);
                letters("S", 3);
                space(3);
                break;
            case 5: 
                space(6);
                letters("S", 3);
                space(1);
                break;
            case 6:
                eightLine("S");
                space(2);
                break;
        }
    }

     //LETTER T
     public void t(int lineNum) {
        switch (lineNum) {
            case 1:
                eightLine("T");
                space(2);
                break;
            default:
                space(3);
                twoLine("T");
                space(5);
                break;
        }
    }

    //LETTER U
    public void u(int lineNum) {
        switch (lineNum) {
            case 1:
            case 2:
            case 3:
            case 4:
                lSL("U", 2, 6);
                space(2);
                break;
            case 5:
                space(1);
                lSL("U", 2, 4);
                space(3);
                break;
            case 6:
                space(2);
                sixLine("U");
                space(4);
                break;
        }
    }

    //LETTER Y
    public void y(int lineNum) {
        switch (lineNum) {
            case 1:
                lSL("Y", 2, 5);
                space(1);
                break;
            case 2:
                space(1);
                lSL("Y", 2, 3);
                space(2);
                break;
            case 3:
                space(2);
                lSL("Y", 2, 1);
                space(3);
                break;
            case 4:
            case 5:
            case 6:
                space(3);
                letters("Y", 3);
                space(7);
                break;
        }
    }

    public void printStudy() {
        System.out.println();
        for (int i = 1; i < 7; i++) {
            s(i);
            t(i);
            u(i);
            d(i);
            y(i);
            System.out.println();
        }
    }

    public void printTime() {
        System.out.println();
        for (int i = 1; i < 7; i++) {
            t(i);
            i();
            m(i);
            e(i);
            System.out.println();
        }
    }

    public void sectionLines() {
        System.out.println();
        letters("*", 55);
        System.out.println();
    }

    public void introArt() {
        sectionLines();
        printStudy();
        printTime();
        sectionLines();
    }

    public void printStart() {
        System.out.println();
        for (int i = 1; i < 7; i++) {
            s(i);
            t(i);
            a(i);
            r(i);
            t(i);
            System.out.println();
        }
    }

    public void printDone() {
        sectionLines();
        for (int i = 1; i < 7; i++) {
            d(i);
            o(i);
            n(i);
            e(i);
            System.out.println();
        }
        sectionLines();
    }
}