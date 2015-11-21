package answer;

public class NumArrayII {
    /**
     * https://leetcode.com/problems/range-sum-query-mutable/
     */
    class SegmentTree {
        int start, end;
        SegmentTree left, right;
        int num;

        public SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            num = 0;
        }
    }

    SegmentTree root = null;

    public NumArrayII(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTree buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        SegmentTree result = new SegmentTree(start, end);
        if (start == end) {
            result.num = nums[start];
        } else {
            int mid = (start + end) / 2;
            result.left = buildTree(nums, start, mid);
            result.right = buildTree(nums, mid + 1, end);
            result.num = result.left.num + result.right.num;
        }

        return result;
    }

    void update(int i, int val) {
        updateTree(root, i, val);
    }

    private void updateTree(SegmentTree root, int pos, int val) {
        if (root.start == root.end) {
            root.num = val;
        } else {
            int mid = (root.start + root.end) / 2;
            if (pos <= mid) {
                updateTree(root.left, pos, val);
            } else {
                updateTree(root.right, pos, val);
            }

            root.num = root.left.num + root.right.num;
        }
    }

    public int sumRange(int i, int j) {
        return getRange(root, i, j);
    }

    private int getRange(SegmentTree root, int i, int j) {
        if (root.start == i && root.end == j)
            return root.num;
        int mid = (root.start + root.end) / 2;
        if (j <= mid) {
            return getRange(root.left, i, j);
        } else if (i >= mid + 1) {
            return getRange(root.right, i, j);
        } else {
            return getRange(root.right, mid + 1, j) + getRange(root.left, i, mid);
        }
    }

    public static void main(String[] args) {
        int[] n = new int[] {-1};
        NumArrayII na = new NumArrayII(n);
        System.out.println(na.sumRange(0, 0));
        na.update(0,1);
        System.out.println(na.sumRange(0, 0));
    }
}
