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

        if (depth != 0)
            return false;

        return str[length - 1].equals("#");
    }
}
