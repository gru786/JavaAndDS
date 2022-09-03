package SortingAlgorithms;

import HelperPrograms.PrintArray;

public class MergeSort {
    public static void main(String[] args){
        int arr[] = {4,2,5,6,1,0};
        mergeSort(arr);
        PrintArray.printArray(arr);
    }

    public static void mergeSort(int[] arr){
        if(arr.length == 0 || arr.length == 1){
            return;
        }
        int n = arr.length;
        int mid = n/2;
        int[] s1 = new int[mid];
        int[] s2 = new int[n-mid];
        int i = 0;
        int j =0;
        while(i < mid){
            s1[j] = arr[i];
            i++;
            j++;
        }
        j=0;
        while(i < n){
            s2[j] = arr[i];
            i++;
            j++;
        }

        mergeSort(s1);
        mergeSort(s2);
        merge(s1, s2, arr);

    }

    public static void merge(int[] s1, int[] s2, int[] arr){
        int m = s1.length;
        int n = s2.length;
        int i = 0, j=0, k=0;
        while(i<m && j < n){
            if(s1[i] < s2[j]){
                arr[k] = s1[i];
                k++;
                i++;
            }
            else{
                arr[k] = s2[j];
                j++;
                k++;
            }
        }
        while(i < m){
            arr[k] = s1[i];
            k++;
            i++;
        }
        while(j < n){
            arr[k] = s2[j];
            k++;
            j++;
        }
    }
}
