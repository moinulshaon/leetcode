import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        ListNode now = null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
        	return a.val - b.val;
        });
        
        for (ListNode node: lists) {
        	if (node != null) {
        		pq.add(node);	
        	}
        }
        
        while (!pq.isEmpty()) {
        	ListNode f = pq.poll();
        	if (ret == null) {
        		ret = now = f;
        	} else {
        		now.next = f;
        		now = now.next;
        	}
        	
        	if (f.next != null) {
        		pq.add(f.next);
        	}
        }
        return ret;
    }
}