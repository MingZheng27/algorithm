import java.util.*;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.

该题不能使用暴力破解，使用暴力破解会出现超时问题，利用一个hashmap的key来存放字符，用其value来存放出现的位置，
若碰上相同的字符时将前一个字符位置取出，并加一即可保证取得连续最长不重复字符串。
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        if (ch.length == 0){
            return 0;
        }
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0,j = 0;i < ch.length ;++i){
            if (map.containsKey(ch[i])){
                j = Math.max(j,map.get(ch[i]) + 1);
            }
            map.put(ch[i],i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
