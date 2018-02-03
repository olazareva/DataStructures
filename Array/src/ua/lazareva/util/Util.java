package ua.lazareva.util;

import java.util.InputMismatchException;

public class Util {

    /*1) принимает массив чаров, выводит его на экран*/

    public void print(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println();
    }


    /*2) принимает массив интов, возвращает массив чаров, каждый символ в позиции массива
         соответствует коду символа передаваемого инта*/

    public char[] unicodeIntToChar(int[] array) {
        char[] charArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            charArray[i] = (char) (array[i]);
        }
        return charArray;
    }

    /*3) приминает 2 инта, а и б, возвращает большее их этих 2х чисел*/

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    /*4) принимает 3 инта, возвращает большее из них*/

    public int max(int a, int b, int c) {
        return max(max(a, b),c);
    }

    /*5) приминает 5 интов, возвращает большее из них*/

    public int max(int a, int b, int c, int d, int e) {
        return max(max(max(a, b),max(c,d)),e);
    }

    /*6) принимает массив чаров, возвращает строку состоящую из символов массива*/

    public String toString(char[] array) {
        String str = "";
        for (char c : array) {
            str += c;
        }
        return str;
    }

    /*8) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает
         с передаваемым, начиная с начала массива. Если значения в массиве нет возвращает -1*/

    public int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /*9) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает
         с передаваемым, начиная с конца массива. Если значения в массиве нет возвращает -1*/

    public int lastIndexOf(int[] array, int value) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /*10) метод принимает инт, и возвращает факториал от заданого инта*/

    public int factorial(int n) {
        if (n >= 0 & n <= 12) {
            if (n == 0) {
                return 1;
            } else return n*factorial(n-1);
        } else {
            throw new IndexOutOfBoundsException("Parameter n should be positive or equals to 0");
        }
    }

    /*11) принимает инт год, и возвращает тру если год высокосный*/

    boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    /*12) приминает массив интов и число, выводит на екран только елементы массива которые кратны этому числу*/

    void printMultipliers(int[] array, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Parameter n should be positive and not equals to 0");
        }
        for (int i : array) {
            if (i % n == 0) {
                System.out.print("[" + i + "]");
            }
        }
        System.out.println();
    }

    /*13) метод принимает массив интов сортирует его по возрастанию*/

    void sortAsc(int[] array) {
        for (int j = array.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }

    /*14) принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру*/

    boolean hasDuplicates(byte[] array) {
        boolean[] hasDuplicates = new boolean[256];
        for (int i = 0; i < array.length; i++) {
            if (!hasDuplicates[array[i] + 128]) {
                hasDuplicates[array[i] + 128] = true;
            } else {
                return true;
            }
        }
        return false;
    }

    /*15) принимает два массива интов одинаковых по длинне, возращает массив интов который состоит
    из перемноженных елементов входящих массивов*/

    int[] multiplyArrays(int[] firstArray, int[] secondArray) {
        if (firstArray.length != secondArray.length) {
            throw new IllegalArgumentException("Input arrays must have same size");
        }
        int[] result = new int[firstArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = firstArray[i] * secondArray[i];
        }
        return result;
    }

    /*16) принимает два массива интов, возвращает массив из елементов которые не совпадают в массивах*/

    int[] getDiscrepancy(int[] array1, int[] array2) {
        int[] values = new int[array1.length + array2.length];
        int[] counters = new int[array1.length + array2.length];
        int actualLength = 0;
        int updated;

        values[actualLength] = array1[0];
        counters[actualLength]++;
        actualLength++;

        for (int i = 1; i < array1.length; i++) {
            updated = 0;
            for (int j = 0; j < actualLength; j++) {
                if (array1[i] == values[j]) {
                    counters[j]++;
                    updated = 1;
                    break;
                }
            }

            if (updated == 0) {
                values[actualLength] = array1[i];
                counters[actualLength]++;
                actualLength++;
            }
        }



        for (int i = 0; i < array2.length; i++) {
            updated = 0;
            for (int j = 0; j < actualLength; j++) {
                if (array2[i] == values[j]) {
                    counters[j] = 0;
                    updated = 1;
                    break;
                }
            }

            if (updated == 0) {
                values[actualLength] = array2[i];
                counters[actualLength]++;
                actualLength++;
            }
        }
        int resultLength = 0;
        for (int counter : counters) {
            resultLength += counter;
        }

        int[] result = new int[resultLength];
        int j = 0;
        for (int i = 0; i < actualLength; i++) {

            if (counters[i] == 1) {
                result[j] = values[i];
                j++;
            }
        }
        return result;
    }

    /*17) принимает масив интов, возвращает его же но в реверсном порядке*/

    int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        return array;
    }
        /*18) принимает 3 инта:
            - размер выходного массива
            - нижняя граница
            - верхняя граница
              возвращает массив интов заданой длинный, который содержит случайные числа от нижней границы до верхней границы*/

    int[] generateRandom(int size, int minValue, int maxValue) {
        validateInput(size, minValue, maxValue);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = minValue + (int) (Math.random() * (maxValue - minValue));
        }
        return array;
    }

    private void validateInput(int size, int minValue, int maxValue) {
        if (size <= 0) {
            throw new IllegalArgumentException("Array size "+ size +" must be a positive number!");
        }
        if (minValue > maxValue) {
            throw new IllegalArgumentException("You have set min value "+ minValue+" > max value "+ maxValue+"!");
        }
    }

    /*19) принимает 2 массива чаров, проверяет есть ли в 1 массиве, такая же последовательность символов
          которую представляет собой второй массив. Возвращает булеан*/
    
    boolean contains(char[] lookAt, char[] lookFor) {
        if (lookAt.length < lookFor.length) {
            throw new InputMismatchException("Array to find is larger that array you look at!");
        }
        for (int i = 0; i < lookAt.length; i++) {
            for (int j = 0; j < lookFor.length; j++) {
                if (i + j < lookAt.length) {
                    if (lookAt[i + j] != lookFor[j]) {
                        break;
                    }
                    if (j == lookFor.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
