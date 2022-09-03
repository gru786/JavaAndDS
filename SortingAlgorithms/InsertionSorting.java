package SortingAlgorithms;
import java.util.Scanner;

import HelperPrograms.PrintArray;
import HelperPrograms.TakeArrInp;

public class InsertionSorting {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = TakeArrInp.takeArrayInput(n);
        System.out.println("Array before sorting: ");
        PrintArray.printArray(arr);
        InsertionSortBetterCode(arr);
        System.out.println("Array after sorting: ");
        PrintArray.printArray(arr);
    }
    public static void InsertionSortBetterCode(int[] arr){
        int key;
        for(int i=1; i< arr.length;i++){
            int j = i-1;
            key = arr[i];
            while(j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void InsertionSort(int[] arr){
        int key, j;
        int n = arr.length;
        for(int i = 1; i< n; i++){
            key = arr[i];
            for(j = i-1; j>=0;j--){
                if(arr[j]> key){
                    arr[j+1] = arr[j];
                }
                else{
                    break;
                }
            }
            arr[j+1] = key;
        }
    }

}
