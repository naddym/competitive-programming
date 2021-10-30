class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] pr: prerequisites) {
            map.computeIfAbsent(pr[0], k -> new ArrayList<>()).add(pr[1]);
        }
        
        int[] visited = new int[numCourses];
        
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (visited[entry.getKey()] != 1) {
                if (detectCycle(map, visited, entry.getKey())) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean detectCycle(Map<Integer, List<Integer>> map, int[] visited, int key) {
        if (visited[key] == 2) {
            return true;
        }
        
        //processing
        visited[key] = 2;
        if (map.containsKey(key)) {
            for (int prCourse : map.get(key)) {
                if (visited[prCourse] != 1) {
                    if (detectCycle(map, visited, prCourse)) {
                        return true;
                    }
                }
            }   
        }
        
        // processed
        visited[key] = 1;
        
        return false;
    }
}
