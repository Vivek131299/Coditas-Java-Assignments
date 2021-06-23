import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;

        int[] nums3 = new int[length3]; // Creating nums3 Array for merging nums1 and nums2 Arrays.

        System.arraycopy(nums1, 0, nums3, 0, length1); // Copying nums1 Array to nums3 Array.
        System.arraycopy(nums2, 0, nums3, length1, length2); // Copying nums2 Array to nums3 Array.

        Arrays.sort(nums3); // Sorting nums3 Array.
        int mid = length3 / 2; // Middle index of nums3 Array.

        if (length3 % 2 == 0) { // If the length of nums3 Array is even.
            System.out.println("Median is " + (double) (nums3[mid-1] + nums3[mid]) / 2); // printing out the median by averaging [mid] and [mid-1] element of nums3 Array.
        } else { // If the length of nums3 Array is odd.
            System.out.println("Median is " + nums3[mid]); // As the length is odd, mid element is itself the median.
        }
    }
}
