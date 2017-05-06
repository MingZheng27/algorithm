package com.zmm.niucoder;
/**
二分查找
**/
public class Binary_Search {

	public static void main(String[] args) {
		Binary_Search b = new Binary_Search();
		int result = b.getPos(new int[]{4,4,10,21}, 4, 4);
		System.out.println(result);
	}

	public int getPos(int[] A, int n, int val) {
		//传入的是索引
        return div(A,0,n - 1,val);
    }

    public int div(int[] A,int start,int end,int val){
    	if (val == A[A.length - 1]){
    		return A.length - 1;
    	}
        int mid = (start + end ) / 2;
        if (A[mid] == val){
        	//mid短路，一旦mid == 0,就不判断后面的mid - 1也就不会出现数组越界
        	while (mid > 0 && A[mid - 1] == val){
        		mid = mid - 1;
        	}
            return mid;
        }
        if (start == end){
            return -1;
        }
        if (A[mid] > val){
            return div(A,start,mid,val);
        }
        if (A[mid] < val){
            return div(A,mid,end,val);
        }
        return 0;
    }
}
