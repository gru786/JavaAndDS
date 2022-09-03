package SortingAlgorithms;
import java.util.Scanner;

import HelperPrograms.PrintArray;
import HelperPrograms.TakeArrInp;
public class BubbleSorting {
    

    public static void main(String[] args){
            int n;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the array");
            n = sc.nextInt();

            int[] arr = TakeArrInp.takeArrayInput(n);
            System.out.println("Array before sorting: ");
            PrintArray.printArray(arr);
            BubbleSort(arr);
            System.out.println("Array after sorting");
            PrintArray.printArray(arr);

    }

    public static void BubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i< n; i++){
            for(int j =0; j< n-i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                }
            }
        }
    }
}
