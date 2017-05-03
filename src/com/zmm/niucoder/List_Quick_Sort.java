package com.zmm.niucoder;

import java.util.*;
//链表的快速排序
public class List_Quick_Sort{

	public static void main(String[] args) {
//		ListNode node = new ListNode(4,new ListNode(2, new ListNode(5, new ListNode(3,
//				new ListNode(7, new ListNode(9, new ListNode(0, new ListNode(1, null))))))));
		ListNode node = null;
		listQuickSort(node);
		while (node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode listQuickSort(ListNode head){
		return quickSort(head,null);
	}

	public static ListNode quickSort(ListNode head,ListNode end){
		if (head != end){
			ListNode middle = partition(head,end);
			quickSort(head,middle);
			quickSort(middle.next,end);
		}
		return head;
	}

	public static ListNode partition(ListNode head,ListNode end){
		int flag = head.val;
		ListNode i = head;
		ListNode j = head.next;
		while (j != end){
			if (j.val < flag){
				i = i.next;
				int temp = i.val;
				i.val = j.val;
				j.val = temp;
			}
			j = j.next;
		}
		int temp = head.val;
		head.val = i.val;
		i.val = temp;
		return i;
	}

}

class ListNode{
	ListNode next;
	int val;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
class Compare implements Comparator<ListNode>{

	@Override
	public int compare(ListNode o1, ListNode o2) {
		if (o1.val > o2.val){
			return 1;
		}
		if (o1.val < o2.val){
			return -1;
		}
		return 0;
	}

}
