package com.tsvetanilievdev;
import java.util.Arrays;

public class Main {
    //Strings
    public static String abbreviate(String source, int maxLength) {
        return source.substring(0,maxLength) + "...";
    }

    public static boolean contains(String source, char symbol) {
        int index = source.indexOf(symbol);
        return index == -1 ? false: true;
    }

    public static boolean endsWith(String source, char target) {
        return source.charAt(source.length() - 1) == target;
    }

    //Arrays
    public static int[] addFirst(int[] source, int element) {
        int[] newArray = new int[source.length + 1];
        newArray[0] = element;

        for (int i = 0; i < source.length ; i++) {
            newArray[i + 1] = source[i];
        }

        return newArray;

    }

    public static boolean contains(int[] source, int element) {
        boolean isContains = false;
        for (int num: source) {
            if(num == element) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    public static void copyFrom(int[] sourceArray, int sourceStartIndex,
                                int[] destinationArray, int destStartIndex, int count) {
        int index = destStartIndex;
        for (int i = sourceStartIndex; i < sourceStartIndex + 2; i++) {
            destinationArray[index] = sourceArray[i];
            index++;
        }

        System.out.println(Arrays.toString(destinationArray));

        System.out.println("This will cause merge conflict");
    }
}