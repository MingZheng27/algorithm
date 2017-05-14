import java.util.*;

public class HeapSort{
	
	public static void main(String[] args){
		int[] input = new int[]{3,2,4,4,5,7,1,2,3,11,15,3,2,1};
		heapSort(input);
		System.out.println(Arrays.toString(input));			
	}
	
	public static void heapSort(int[] arr){
		for (int i = arr.length - 1;i > 0 ;i--){
			buildHeap(arr,i);
			swap(arr,0,i);
		}		
	}

	public static void buildHeap(int[] arr,int end){
		//当前节点	
		for (int i = (end - 1) / 2;i >=0;i--){
			int cur = i;
			//迭代来修正堆，因为只有有子节点的才需要修正，因此cur * 2 + 1 <= end时才需要while
			while (cur * 2 + 1 <= end){
				int biggerindex = cur * 2 + 1;
				if (biggerindex + 1 <= end && arr[biggerindex + 1] > arr[biggerindex]){
					biggerindex++;
				}
				if (arr[biggerindex] > arr[cur]){
					swap(arr,biggerindex,cur);
					cur = biggerindex;
				}else{
					break;
				}
			}
		}
	}
	
	//交换
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}