//Given two strings s and t which consist of only lowercase letters.

//String t is generated by random shuffling string s and then add one more letter at a random position.

//Find the letter that was added in t.


//my solution is changing string s and t to char[] cs,ct, add ct to result list first, and then loop the cs, if result list contains cs[i],then remove it.
//finally, return the first element as result.
// I found that I donot need to change string to char[] ,I can use string.charAt(i) function as a char[].

    public char findTheDifference(String s, String t) {  
		List<Character> list = new ArrayList<>();
		for (int i = 0; i<t.length(); i++) {
			list.add(t.charAt(i));
		}
		for (int i = 0; i<s.length(); i++) {
			if(list.contains(s.charAt(i))){
				
				list.remove((Character)s.charAt(i));
			}
		}
		char res = (char)list.toArray()[0];

		return res;
    }
    
    
//my solution is very slow, I found a solution with bit operation which is very fast.
//this question is like: there is an array with each element appears twice exception one element, find the element appears one time

    public char findTheDifference(String s, String t) {
		char res = t.charAt(0);
		for (int i = 1;i<t.length() ;i++ ) {
			res^=s.charAt(i-1);
			res^=t.charAt(i);
		}
		return res;
    }

    
    
 
