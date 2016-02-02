package answer;

public class VerifyPreorderSerializationOfBST {
    /**
     * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        String[] str = preorder.split(",");
        int depth = 0, i = 0, length = str.length;
        while (i < length - 1) {
            if (str[i ++].equals("#")) {
                if (depth == 0)
                    return false;
                depth --;
            } else {
                depth ++;
            }
        }

        return depth == 0 && str[length - 1].equals("#");
    }

    public boolean isValidSerialization2(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        String[] str = preorder.split(",");
        int diff = 1;
        for (String s : str) {
            if (--diff < 0) return false;
            if (!s.equals("#"))
                diff += 2;
        }

        return diff == 0;
    }
}
