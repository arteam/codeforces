import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public TreeNode constructMaximumBinaryTree(List<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        if (nums.size() == 1) {
            return new TreeNode(nums.get(0));
        }
        int maxValueIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > maxValue) {
                maxValue = nums.get(i);
                maxValueIndex = i;
            }
        }
        TreeNode leftNode = constructMaximumBinaryTree(nums.subList(0, maxValueIndex));
        TreeNode rightNode = constructMaximumBinaryTree(nums.subList(maxValueIndex + 1, nums.size()));
        return new TreeNode(maxValue, leftNode, rightNode);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}


