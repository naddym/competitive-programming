/**
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example 2:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 
Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst

*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight: flights) {
            map.computeIfAbsent(flight[0], key -> new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        
        int stops = 0, minCost = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] flight = queue.poll();
                if (flight[0] == dst) {
                    minCost = Math.min(minCost, flight[1]);
                } else {
                    if (map.containsKey(flight[0])) {
                        for(int[] f : map.get(flight[0])) {
                            if (f[1] + flight[1] < minCost) {
                                queue.add(new int[]{f[0], f[1] + flight[1]});
                            }
                        }
                    } 
                }
            }
            
            if (stops++ > k) {
                break;
            }
        }
        
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}