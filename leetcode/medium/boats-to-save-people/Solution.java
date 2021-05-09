/**
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 
Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104

*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0 || limit == 0) {
            return 0;
        }
        
        Arrays.sort(people);
                    
        int save = 0, n = people.length;
        while (n > 0) {
            int m = n / 2;
            save += maxWeight(people, m, n, limit);
            
            // move all zeores to right
            int index = 0;
            for (int i = 0; i < m; i++) {
                if (people[i] != 0) {
                    people[index++] = people[i];
                }
            }
            for (int i = index; i < m; i++) {
                people[i] = 0;
            }
            
            n = n / 2;
        }
        
        return save;
    }
    
    private int maxWeight(int[] people, int m, int n, int limit) {
        int save = 0;
        for(int i = n - 1; i >= m; i--) {
            
            if (people[i] == 0) {
                continue;
            }

            int j = 0;
            int count = 0;
            while (j < m) {
                if (people[j] == 0) {
                    count++;
                } else if (people[j] + people[i] <= limit) {
                    people[j] = 0;
                    save++;
                    break;
                } else {
                    save++;
                    break;
                }
                j++;
            }
            
            // we have exhausted the left possibilities
            if (count == m) {
                save++;
            }
        }
        
        return save;
    }
}