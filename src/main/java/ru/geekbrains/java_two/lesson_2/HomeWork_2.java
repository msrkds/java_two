package ru.geekbrains.java_two.lesson_2;

import java.util.Arrays;

public class HomeWork_2 {

    public static class MyArrayDataException extends Exception {
        public int i;
        public int j;

        MyArrayDataException(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static class MyArraySizeException extends Exception {
    }

    private static final String[][] CORRECT_ARRAY = {{"3", "7", "5", "0"}, {"1", "2", "3", "4"}, {"11", "22", "44", "55"}, {"3", "6", "9", "12"}};

    private static final String[][] EXTRA_ROW_ARRAY = {{"3", "7", "5", "0"}, {"1", "2", "3", "4"}, {"11", "22", "44", "55"}, {"3", "6", "9", "12"}, {"3", "3", "3", "3"}};

    private static final String[][] EXTRA_COL_ARRAY = {{"3", "7", "5", "0"}, {"1", "2", "3", "11" ,"4"}, {"11", "22", "44", "55"}, {"3", "6", "9", "12"}};

    private static final String[][] NO_ROW_ARRAY = {{"3", "7", "5", "0"}, {"1", "2", "3", "11"}, {"11", "22", "44", "55"}};

    private static final String[][] NO_COL_ARRAY = {{"3", "7", "5", "0"}, {"1", "2", "3"}, {"11", "22", "44", "55"}, {"3", "6", "9", "12"}};

    private static final String[][] HAS_CHAR_ARRAY = {{"3", "7", "5", "F"}, {"1", "2", "3", "4"}, {"11", "22", "44", "55"}, {"3", "6", "9", "12"}};


    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] arr = HAS_CHAR_ARRAY ;

        try {
            try {
                System.out.println("Сумма элементов массива: " + method(arr));
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива должен быть только 4 х 4!");
                System.out.println("Текущий размер массива: " + arr.length + " x " + arr[1].length );
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }
}