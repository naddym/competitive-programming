/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
                
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pr : prerequisites) {
            int a = pr[0], b = pr[1];
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a); 
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
        }

        boolean[] visited = new boolean[numCourses];
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if (!visited[entry.getKey()]) {
                if (detectCycle(map, entry.getKey(), new HashSet<>(), visited)) {
                    return false;   
                }
            }
        }
        
        return true;
    }
    
    private boolean detectCycle(Map<Integer, Set<Integer>> map, int key, Set<Integer> set, boolean[] visited) {
        if (set.contains(key)) {
            return true;
        }
        
        for (int value: map.get(key)) {
            if (!visited[value]) {
                set.add(key);
                if (detectCycle(map, value, set, visited)) {
                    return true;
                }
                visited[value] = true;
                set.remove(key);  
            }
        }
        
        visited[key] = true;
        
        return false;
    }
}