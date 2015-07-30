package answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
	/**
	 * https://leetcode.com/problems/course-schedule-ii/
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int n = prerequisites.length;
		List<List<Integer>> adjacent = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; ++i) {
			adjacent.add(i, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n; ++i) {
			adjacent.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		
		boolean[] visited = new boolean[numCourses];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < numCourses; ++i) {
			if (!dfs(stack, adjacent, visited, i, new boolean[numCourses]))
				return new int[0];
		}
		
		int[] result = new int[numCourses];
		int index = 0;
		while (!stack.isEmpty()) {
			result[index ++] = stack.pop();
		}
		return result;
    }
	
	private boolean dfs(Stack<Integer> stack, List<List<Integer>> adjacent, boolean[] visited, int v, boolean[] isLoop) {
		if (visited[v] == true)
			return true;
		if (isLoop[v] == true)
			return false;
		isLoop[v] = true;
		List<Integer> list = adjacent.get(v);
		for (int u : list) {
			if (!dfs(stack, adjacent, visited, u, isLoop)) 
				return false;
		}
		visited[v] = true;
		stack.push(v);
		return true;
	}
}
