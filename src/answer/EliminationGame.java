package answer;

public class EliminationGame {
    /**
     * https://leetcode.com/problems/elimination-game/
     */
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}
