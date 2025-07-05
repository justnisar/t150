package src;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = nums1.length;
        while (left <= right){
            int cut1 = left + (right - left)/2;
            int cut2 = (m + n + 1)/2 - cut1;
            int maxLeft1 = cut1 - 1 >= 0 ? nums1[cut1 - 1] : Integer.MIN_VALUE;
            int minRight1 = cut1 < m ? nums1[cut1] : Integer.MAX_VALUE;
            int maxLeft2 = cut2 - 1 >= 0 ? nums2[cut2 - 1] : Integer.MIN_VALUE;;
            int minRight2 = cut2 < n ? nums2[cut2] : Integer.MAX_VALUE;

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                // even
                if((m + n) % 2 == 0){
                    int maxLeft = Math.max(maxLeft1, maxLeft2);
                    int minRight = Math.min(minRight1, minRight2);
                    return ((double)maxLeft + minRight)/2;
                }
                else{
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            else if(maxLeft1 > minRight2){
                right = cut1 - 1;
            }
            else{
                left = cut1 + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {1,3};
        int[] array2 = {2};
        new MedianOfTwoSortedArrays().findMedianSortedArrays(array1, array2);
    }

}
