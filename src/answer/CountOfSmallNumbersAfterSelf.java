package answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallNumbersAfterSelf {
    /**
     * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
     */
//    class Node {
//        Node left, right;
//        //sum recording the total of number on it's left bottom side
//        //dup counts the duplication
//        int val, sum, dup = 1;
//        public Node(int v, int s) {
//            val = v;
//            sum = s;
//        }
//    }
//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] ans = new Integer[nums.length];
//        Node root = null;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            root = insert(nums[i], root, ans, i, 0);
//        }
//        return Arrays.asList(ans);
//    }
//    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
//        if (node == null) {
//            node = new Node(num, 0);
//            ans[i] = preSum;
//        } else if (node.val == num) {
//            node.dup ++;
//            ans[i] = preSum + node.sum;
//        } else if (node.val > num) {
//            node.sum ++;
//            node.left = insert(num, node.left, ans, i, preSum);
//        } else {
//            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
//        }
//        return node;
//    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Tuple[] array = new Tuple[n];
        for (int i = 0; i < n; ++i)
            array[i] = new Tuple(nums[i], i);
        sort(ans, array, n);
        List<Integer> result = new LinkedList<Integer>();
        for (int x : ans)
            result.add(x);
        return result;
    }

    private Tuple[] sort(int[] ans, Tuple[] a, int n) {
        if (n <= 1)
            return a;
        int i = n / 2, j = n - i;
        Tuple[] left = sort(ans, Arrays.copyOfRange(a, 0, i), i);
        Tuple[] right = sort(ans, Arrays.copyOfRange(a, i, n), j);

        for (int k = n - 1; k > -1; --k) {
            if (j == 0 || (i > 0 && left[i - 1].val > right[j - 1].val)) {
                ans[left[i - 1].idx] += j;
                a[k] = left[--i];
            } else {
                a[k] = right[--j];
            }
        }

        return a;
    }

    class Tuple {
        int val;
        int idx;
        public Tuple(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
