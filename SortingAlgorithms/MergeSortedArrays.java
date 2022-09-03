package SortingAlgorithms;

import HelperPrograms.PrintArray;

public class MergeSortedArrays {
    
    public static void main(String[] args){
        int[] arr1 = {1,4,6,9,10};
        int[] arr2 = {2,3,5};
        int[] resultArr = merge(arr1,arr2);
        PrintArray.printArray(resultArr);
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int m =  arr1.length;
        int n = arr2.length;
        int result[] = new int[m+n];
        int i = 0, j =0, k=0;
        while(i < m && j <n){
            if(arr1[i]< arr2[j]){
                result[k] = arr1[i];
                i++;
                k++;
            }
            else{
                result[k] = arr2[j];
                j++;
                k++;
            }
        }
        
        while(j<n){
            result[k] = arr2[j];
            k++;
            j++;
        }
        
        
        while(i<m){
            result[k] = arr1[i];
            i++;
            k++;
        }
        
        return result;
    }
}
