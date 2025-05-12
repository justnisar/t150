package src;

public class MergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1, j = n-1, k = m+n-1;

        while(i >= 0 && j >= 0){
            if(nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }
            else{
                nums1[k--] = nums1[i--];
            }
        }

        while(i >= 0){
            nums1[k--] = nums1[i--];
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }

    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,0,0,0};
        int[] array2 = {2,5,6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(array1, 3, array2, 3);
    }

}