/*
2. Add Two Numbers
Solved
Medium
Topics
premium lock icon
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

https://leetcode.com/problems/add-two-numbers/description/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> output = new ArrayList<>();

        ListNode v1 = l1;
        ListNode v2 = l2;
        ListNode res = new ListNode();
        while(true){

            if(v1 == null && v2 == null && res.val == 0){
                output.get(output.size()-1).next = null;
                break;
            }

            int value1 = 0;
            int value2 = 0;

            if(v1!=null) value1 = v1.val;
            if(v2!=null) value2 = v2.val;

            int sum = res.val + value1 + value2;

            ListNode new_res = new ListNode(0);
            res.next = new_res;

            if(sum > 9){
                res.val = sum-10;
                v1 = v1!=null ? v1.next : null;
                v2 = v2!=null ? v2.next : null;
                new_res.val = 1;
                output.add(res);
            }
            else{
                res.val = sum;
                v1 = v1!=null ? v1.next : null;
                v2 = v2!=null ? v2.next : null;
                output.add(res);
            }
            res = new_res;
        }

        return output.get(0);
    }
}
