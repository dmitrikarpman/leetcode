// 3. Longest Substring Without Repeating Characters (medium)
// Given a string s, find the length of the longest substring without duplicate characters.
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String,Integer> chars = new HashMap<>(); // hold the latest found char position
        
        int maxLen = 0; // works for zero char string
        int sInd = 0; // adjust it when a dup char is found

        for(int i=0; i<s.length(); i++){
            
	    String ch = ""+s.charAt(i);

            if(chars.containsKey(ch)){
		// jump to the next char after the first dup char, but only if
		// less than already set value, in other words, start Ind
		// can't go back, only forward.
		// +1 is to advance to next char after the first dup
                sInd = (sInd > (int)chars.get(ch)+1) ? sInd : (int)chars.get(ch) + 1;

                maxLen = (maxLen > i - sInd + 1) ? maxLen : i - sInd + 1;
                
                chars.put(ch, i); // the new dup position takes place of the old one
            }
            else{
                chars.put(ch,i);
                maxLen = (maxLen > i - sInd + 1) ? maxLen : i - sInd + 1;
            }
        }

        return maxLen;
    }
}
