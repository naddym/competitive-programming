/**
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.


Example:

Input:  s = "++++"
Output: true. 

Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".

*/

public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String nextState = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(nextState)){
                    return true;
                }
            }
        }

        return false;
    }
}