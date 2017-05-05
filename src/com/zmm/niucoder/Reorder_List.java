package com.zmm.niucoder;
/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

该题涉及到反转链表的问题，而反转链表包括前插法和后插法。

前插法反转链表：

原链表：A->B->C->D

新建一节点E，另A->E，以此类推，可得D->C->B->A->E，可以一开始令E为null这样即可完成链表的反转，并且保证时间复杂度为O(n)

后插法反转链表：

原链表：A->B->C->D

新建一节点E，令E->D，以此类推，可得到反转链表，但由于每次需要循环找到原链表中最后一个节点，因此时间复杂度为O(n^2)

因此此题我们选择前插法反转链表后再将两部分链表融合。
*/
public class Reorder_List {

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(7);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		Reorder_List re = new Reorder_List();
		//		ListNode result = re.relist(node);
		//		while (result != null){
		//			System.out.print(result.val + " ");
		//			result = result.next;
		//		}
		re.reorderList(node);
		while (node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null){
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		slow = relist(slow);
		while (head != slow && head != null){
			ListNode temp = head.next;
			ListNode temp2 = slow.next;
			head.next = slow;
			slow.next = temp;
			slow = temp2;
			head = head.next.next;
		}
	}
//前插法反转链表只需要O(n)复杂度
	public ListNode relist(ListNode head){
		ListNode flag = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = flag;
			flag = head;
			head = temp;
		}
		return flag;
	}
}
