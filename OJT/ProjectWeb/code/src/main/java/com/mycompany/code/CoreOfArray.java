/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.code;

/**
 *
 * @author vinh1
 */
public class CoreOfArray {

    public static int TheCoreOfArray(int[] array) {
        int coreCount = 0;

        while (array.length > 0) {
            int core = array[0];
            int i = 1;

            while (i < array.length) {
                if (array[i] % core == 0) {
                    int[] newArray = new int[array.length - 1];
                    System.arraycopy(array, 0, newArray, 0, i);
                    System.arraycopy(array, i + 1, newArray, i, array.length - i - 1);
                    array = newArray;
                } else {
                    i++;
                }
            }

            coreCount++;
        }

        return coreCount;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 3, 4, 5, 6, 7};
        int[] array2 = {2, 4, 8, 16};

        System.out.println(TheCoreOfArray(array1)); 
        System.out.println(TheCoreOfArray(array2)); 
    }
}

array[0]==31&&array[1]==52&&array[2]==79&&array[3]==177&&array[4]==221&&array[5]==270&&array[6]==327&&