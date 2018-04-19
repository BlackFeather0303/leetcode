/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
*/

该问题并不是一个常规的permutation问题，因为每个字母的顺序是不可以改变的。因为审题失误，理解错了题目。
该题可以用DFS，BFS两种思想来解题。

//BFS
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
			return new ArrayList<>();
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(S);

		for (int i = 0; i<S.length(); i++) {
			if (Character.isDigit(S.charAt(i))) {
				continue;
			}
			int size = queue.size();
			for (int j = 0; j<size; j++) {
				String cur = queue.poll();
				char[] chs = cur.toCharArray();	
				chs[i] = Character.toLowerCase(chs[i]);
				queue.offer(String.valueOf(chs));
                chs[i] = Character.toUpperCase(chs[i]);
				queue.offer(String.valueOf(chs));
			}
		}
		return new LinkedList<>(queue);
    }
}



//DFS


class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helper(S, res, 0);
        return res;
    }
    
    public void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            helper(s, res, pos + 1);
            return;
        }
        
        char[] chs = s.toCharArray();
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
    }
}
