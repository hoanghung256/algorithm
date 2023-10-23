package recursion;

//Recursion is the best way to implement Merge Sort Algorithm
//TC: O(n.log(n))
//SC: O(n) because we need to create sub array to store elements

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {8,2,5,3,4,7,6,1};
        mergeSort(a);
        for (int e : a) {
            System.out.print(e +" ");
        } 
    }
    
    public static void mergeSort(int[] a) {
        int len = a.length; 
        if (len <= 1) return;
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        int i = 0;
        int j = 0;

        for (; i < len; i++) {
            if (i < mid) {
                left[i] = a[i];
            }
            else {
                right[j] = a[i];
                j++;
            }
        }
        
        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
    }
    
    public static void merge(int[] left, int[]right, int[] a) {
        int lSize = a.length / 2;
        int rSize = a.length - lSize;
        int i = 0, l = 0, r = 0;

        while (l < lSize && r < rSize) {
            if (left[l] < right[r]) {
                a[i] = left[l];
                i++;
                l++;
            } else {
                a[i] = right[r];
                i++;
                r++;
            }
        }

        while (l < lSize) {
            a[i] = left[l];
            i++;
            l++;
        }

        while (r < rSize) {
            a[i] = right[r];
            i++;
            r++;
        }
    }
}
