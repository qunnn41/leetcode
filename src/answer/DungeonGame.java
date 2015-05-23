package answer;

public class DungeonGame {
	/**
	 * https://leetcode.com/problems/dungeon-game/
	 */
	public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        
        int [][] health = new int[M][N];
        health[M - 1][N - 1] = (1 - dungeon[M - 1][N - 1]) > 0 ? 1- dungeon[M - 1][N - 1] : 1;
        
        for (int i = M - 2; i > -1; i --) {
            int v = health[i + 1][N - 1] - dungeon[i][N - 1];
            health[i][N - 1] = v > 0 ? v : 1;
        }
        
        for (int i = N - 2; i > -1; i --) {
            int v = health[M - 1][i + 1] - dungeon[M - 1][i];
            health[M - 1][i] = v > 0 ? v : 1;
        }
        
        for (int i = M - 2; i > -1; i --)
            for (int j = N - 2; j > -1; j --) {
                int v = health[i + 1][j] > health[i][j + 1] ? health[i][j + 1] - dungeon[i][j] : health[i + 1][j] - dungeon[i][j];
                health[i][j] = (v > 0) ? v : 1;
            }
                
        return health[0][0];
    }
}
