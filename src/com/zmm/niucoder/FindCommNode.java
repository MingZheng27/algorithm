import java.util.*;

public class FindCommNode{
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		TreeNode result = findNode(node1,node8,node5);
		System.out.println(result.val);
	}
	
	public static TreeNode findNode(TreeNode root,TreeNode a,TreeNode b){
		if (root == null){
			return null;
		}
		if (root == a || root == b){
			return root;
		}
		TreeNode left = findNode(root.left,a,b);
		TreeNode right = findNode(root.right,a,b);
		if (left != null && right != null){
			return root;
		}
		/*
		�������2��8���㣬����ҵ���2�Ժ�ֱ����1�����������ɣ�
		��Ϊ���������û�еĻ�8һ����2��������(���ڵ㲻��8���ֵܼ��ֵܽڵ�Ҳ�������ֻ����2��������)
		���ֱ�ӷ���2���ɣ���1�Ĳ�Ϊnull������
		*/
		return (left == null) ? right : left ;
	}
	
}

class TreeNode{
	
	TreeNode left,right;
	int val;
	
	TreeNode(int val){
		this.val = val;
	}
}