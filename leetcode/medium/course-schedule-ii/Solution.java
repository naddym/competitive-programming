/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 
Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pr : prerequisites) {
            int a = pr[0], b = pr[1];
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a); 
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
        }
        
        // linked hashset to mantain relative ordering
        Set<Integer> result = new LinkedHashSet<Integer>();
        boolean[] visited = new boolean[numCourses];
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if (!visited[entry.getKey()]) {
                if (detectCycle(map, entry.getKey(), new HashSet<>(), visited, result)) {
                    return new int[0];   
                }
            }
        }
        
        LinkedList<Integer> list = new LinkedList<>(result);
        Collections.reverse(list);

        // add independent courses
        if (list.size() < numCourses) {
            for (int i = 0; i < numCourses; i++) {
                if (!list.contains(i)) {
                    list.addFirst(i);
                }
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean detectCycle(Map<Integer, Set<Integer>> map, int key, Set<Integer> set, boolean[] visited, Set<Integer> result) {
        if (set.contains(key)) {
            return true;
        }
        
        for (int value: map.get(key)) {
            if (!visited[value]) {
                set.add(key);
                
                if (detectCycle(map, value, set, visited, result)) {
                    return true;
                }
                visited[value] = true;
                result.add(value);
                set.remove(key);  
            }
        }
        
        result.add(key);
        visited[key] = true;
        
        return false;
    }
}