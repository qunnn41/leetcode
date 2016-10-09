package answer;

import auxiliary.ListNode;

import java.util.Random;

public class LinkedListRandomNode {
    /**
     * https://leetcode.com/problems/linked-list-random-node/
     */
    class Solution {
        ListNode head;
        Random random;
        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            // Reservoir sampling
            ListNode result = head;
            ListNode current = head;
            for (int n = 1; current != null; n ++) {
                if (random.nextInt(n) == 0) {
                    result = current;
                }

                current = current.next;
            }

            return result.val;
        }
    }
}
