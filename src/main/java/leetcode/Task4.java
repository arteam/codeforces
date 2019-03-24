package leetcode;

public class Task4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Task4().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedNums = merge(nums1, nums2);
        int mid = mergedNums.length / 2;
        return mergedNums.length % 2 == 0 ? ((double) mergedNums[mid] + mergedNums[mid - 1]) / 2 : mergedNums[mid];
    }

    private static int[] merge(int[] a, int[] b) {
        int aIndex = 0;
        int bIndex = 0;
        int[] merged = new int[a.length + b.length];
        for (int i = 0; i < merged.length; i++) {
            int aValue = aIndex < a.length ? a[aIndex] : Integer.MAX_VALUE;
            int bValue = bIndex < b.length ? b[bIndex] : Integer.MAX_VALUE;
            if (aValue <= bValue) {
                merged[i] = aValue;
                aIndex++;
            } else {
                merged[i] = bValue;
                bIndex++;
            }
        }
        return merged;
    }
}
