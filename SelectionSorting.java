import java.util.Scanner;

import HelperPrograms.PrintArray;
import HelperPrograms.TakeArrInp;

public class SelectionSorting {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter size of array");
        n = sc.nextInt();
        //TakeArrInp input = new TakeArrInp();
        int arr[] = TakeArrInp.takeArrayInput(n);
        System.out.println("Array before sort: ");
        PrintArray.printArray(arr);
        SelectionSort(arr);
        System.out.println("Array after sort: ");
        PrintArray.printArray(arr);

    }

    public static void SelectionSort(int[] arr){
        int n = arr.length;
        int min;
        int minIndex;
        for(int i = 0; i < n-1; i++){
            min = arr[i];
            minIndex = i;
            for(int j=i+1; j< n; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
