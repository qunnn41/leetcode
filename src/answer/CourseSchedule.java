package answer;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	/**
	 * https://leetcode.com/problems/course-schedule/
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		List<List<Integer>> adjacent = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; ++i) {
			adjacent.add(i, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n; ++i) {
			adjacent.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		
		boolean[] visited = new boolean[numCourses];
		
		for (int i = 0; i < numCourses; ++i) {
			if (!dfs(adjacent, visited, i, new boolean[numCourses]))
				return false;
		}
		
		return true;
    }
	
	private boolean dfs(List<List<Integer>> adjacent, boolean[] visited, int v, boolean[] isLoop) {
		if (visited[v] == true)
			return true;
		if (isLoop[v] == true)
			return false;
		isLoop[v] = true;
		List<Integer> list = adjacent.get(v);
		for (int u : list) {
			if (!dfs(adjacent, visited, u, isLoop))
				return false;
		}
		visited[v] = true;
		return true;
	}
}
