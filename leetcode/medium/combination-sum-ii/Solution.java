/**
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // for unique combination
        Arrays.sort(candidates);

        return combinationSum2(candidates, target, 0);
    }
    
    private List<List<Integer>> combinationSum2(int[] candidates, int target, int j) {
        List<List<Integer>> paths = new ArrayList<>();
        
        if (j > candidates.length || target < 0) {
            return paths;
        } else if (target == 0) {
            paths.add(new ArrayList<>());
            return paths;
        }

        for (int i = j; i < candidates.length; i++) {
            // to avoid re-calculating duplicate 
            if (i == j || candidates[i] != candidates[i - 1]) {
                List<List<Integer>> subPaths = combinationSum2(candidates, target - candidates[i], i + 1);
                if (!subPaths.isEmpty()) {
                    for (List<Integer> subPath : subPaths) {
                        List<Integer> temp = Stream.of(candidates[i]).collect(Collectors.toCollection(() -> subPath));
                           paths.add(temp);
                    }
                }   
            }
        }
        
        return paths;
    }
}