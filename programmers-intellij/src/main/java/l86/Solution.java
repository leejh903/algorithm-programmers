package l86;

class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}

		ListNode current = head;
		ListNode last = null;
		ListNode before = null;
		while (current != null) {
			ListNode next = current.next;

			// less than x
			if (current.val < x) {
				ListNode temp;
				if (last == null) {
					temp = head;
					head = current;
				} else {
					temp = last.next;
					last.next = current;
				}
				current.next = temp;
				last = current;

				if (before != null) {
					before.next = next;
				}
			}

			// greater than or equal to x
			if (current.val >= x) {
				before = current;
			}

			current = next;
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
