package l61;

// 마지막을 head랑 연결
// head를 해당 순서로 변경
// 해당 순서 바로 앞에 것의 다음을 null처리

class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		int n = 1;
		ListNode last = head;
		while (last != null && last.next != null) {
			n++;
			last = last.next;
		}

		int remaining = k % n;
		if (n <= 1 || remaining == 0) {
			return head;
		}

		ListNode current = head;
		int index = 0;
		while (current.next != null) {
			// stop before the future first place
			if (index == n - remaining - 1) {
				ListNode next = current.next;

				last.next = head;
				head = next;
				current.next = null;
				break;
			}
			current = current.next;
			index++;
		}
		return head;
	}

	// Definition for singly-linked list.
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
