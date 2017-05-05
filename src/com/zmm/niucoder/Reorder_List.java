package com.zmm.niucoder;
/*
Given a singly linked list L: L0��L1������Ln-1��Ln,
reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

�����漰����ת��������⣬����ת�������ǰ�巨�ͺ�巨��

ǰ�巨��ת����

ԭ����A->B->C->D

�½�һ�ڵ�E����A->E���Դ����ƣ��ɵ�D->C->B->A->E������һ��ʼ��EΪnull���������������ķ�ת�����ұ�֤ʱ�临�Ӷ�ΪO(n)

��巨��ת����

ԭ����A->B->C->D

�½�һ�ڵ�E����E->D���Դ����ƣ��ɵõ���ת����������ÿ����Ҫѭ���ҵ�ԭ���������һ���ڵ㣬���ʱ�临�Ӷ�ΪO(n^2)

��˴�������ѡ��ǰ�巨��ת������ٽ������������ںϡ�
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
//ǰ�巨��ת����ֻ��ҪO(n)���Ӷ�
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
