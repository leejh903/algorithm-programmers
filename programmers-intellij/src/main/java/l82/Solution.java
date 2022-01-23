package l82;

class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		// lastVal is used to indicate duplication
		int lastVal = head.val;
		// current is pointer which tells current position
		ListNode current = head;
		// past is last position which is confirmed
		ListNode past = null;
		// duplicated tells this value is duplicated or not
		boolean duplicated = false;
		while (current.next != null) {
			ListNode next = current.next;
			if (next.val != lastVal) {
				if (!duplicated) {
					if (past == null) {
						head = current;
					} else {
						past.next = current;
					}
					past = current;
				}
				lastVal = next.val;
				duplicated = false;
			} else {
				duplicated = true;
			}
			current = next;
		}

		// deal last values which is not processed in while loop
		if (!duplicated) {
			if (past == null) {
				head = current; // [1, 1, 1, 2]
			} else {
				past.next = current; // normal case
			}
		} else {
			if (past == null) {
				head = null; // [1, 1]
			} else {
				past.next = null; // normal
			}
		}
		return head;
	}

	public class ListNode {
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
}
