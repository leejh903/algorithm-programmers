package l83;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		Set<Integer> nums = new HashSet<>();
		ListNode current = head;
		while (current.next != null) {
			nums.add(current.val);
			ListNode next = current.next;
			// adjust current next
			if (nums.contains(next.val)) {
				current.next = next.next;
			} else { // move current position
				current = next;
			}
		}
		return head;
	}
}


class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
