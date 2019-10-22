package com.git;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        int i = new Solution().strStr("", "a");
        System.out.println(i);

    }

    /**
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] src = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i < src.length; i++) {
            if (src[i] == target[0] && check(src, i, target)) {
                return i;
            }
        }
        return -1;
    }

    public boolean check(char[] src, int startPoint, char[] target) {
        if (target.length == 1) {
            return true;
        }
        for (int i = 1; i < target.length; i++) {
            if (startPoint + i >= src.length || target[i] != src[startPoint + i]) {
                return false;
            }
        }
        return true;
    }
}