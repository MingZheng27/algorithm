package com.zmm.niucoder;
/*
链表的插入排序
*/
public class Insert_Sort_List {

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(6);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Insert_Sort_List sort = new Insert_Sort_List();
		ListNode result = sort.insertionSortList(node);
		while (result != null){
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null){
			return null;
		}
		ListNode node = new ListNode(head.val);
		ListNode flag = node;//标记 头节点
		head = head.next;
		while (head != null){
			if (head.val <= node.val){
				ListNode n = new ListNode(head.val);
				n.next = node;
				flag = n;
				node = flag;
				head = head.next;
				continue;
			}
			while (node != null){
				if (node.next == null && head.val >= node.val){
					ListNode n = new ListNode(head.val);
					node.next = n;
					break;
				}
				if (head.val >= node.val && head.val <= node.next.val){
					ListNode n = new ListNode(head.val);
					n.next = node.next;
					node.next = n;
					break;
				}
				node = node.next;
			}
			node = flag;
			head = head.next;
		}
		return flag;
    }
}
