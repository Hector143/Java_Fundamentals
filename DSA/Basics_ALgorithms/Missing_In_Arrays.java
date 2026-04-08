package Basics_ALgorithms;
import java.util.Scanner;
public class Missing_In_Arrays {

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        int n = arr.length + 1;

        for (int num = 1; num <= n; num++) {
            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Missing number is: " + num);
                break;
            }
        }
    }
}
