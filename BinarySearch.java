import java.util.Scanner;
class BinarySearch{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of input array");
        n = sc.nextInt();
        int i = 0;
        int[] arr = new int[n];
        while(i < n){
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println("Enter the elemet you wish to find in the array");
        int searchElement = sc.nextInt();
        int result = BinarySearching(searchElement, arr);
        if(result == -1){
            System.out.println("Element not present in the given array");
        }
        else{
            System.out.println("Element is present at index: " + result);
        }
    }

    public static int BinarySearching(int searchElement, int[] arr){
        int start = 0;
        int end = arr.length;
        int result = -1;
        while(start < end){
            //1 2 3 4 5
            int mid = (start + end)/2;
            if(arr[mid] == searchElement){
                return mid;
            }
            else if(arr[mid] < searchElement){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return result;
    }
}