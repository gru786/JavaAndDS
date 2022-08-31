package HelperPrograms;
import java.util.Scanner;

public class TakeArrInp {
    
    public static int[] takeArrayInput(int n){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int[] arr = new int[n];
        while(i < n){
            System.out.print("Enter the " + i + " element of array: ");
            arr[i] = sc.nextInt();
            i++;
        }
        return arr;
    }
}
