package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists">21. 合并两个有序链表</a>
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode currNode = dummyHead;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                currNode.next = node1;
                node1 = node1.next;
            } else {
                currNode.next = node2;
                node2 = node2.next;
            }

            currNode = currNode.next;
        }

        currNode.next = node1 == null ? node2 : node1;

        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
