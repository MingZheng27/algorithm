

public class MergeTwoList{
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode currNode = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                currNode.next = l1.val < l2.val ? l1 : l2;
                currNode = currNode.next;
                if (l1.val < l2.val) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
                continue;
            }
            if (l1 != null) {
                currNode.next = l1;
                currNode = currNode.next;
                l1 = l1.next;
            }
            if (l2 != null) {
                currNode.next = l2;
                currNode = currNode.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }
	
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}