import java.util.*;

public class MergeSort{
	
	public static void main(String[] args){
		int[] input = new int[]{4,3,1,5,9,2,34,12,56,77,66};
		mergeSort(input,0,input.length - 1);
		System.out.println(Arrays.toString(input));
	}
	
	public static void mergeSort(int[] arr,int start,int end){
		if (end > start){
			int mid = (start + end) / 2;
			mergeSort(arr,start,mid);
			mergeSort(arr,mid + 1,end);
			merge(arr,start,mid,end);
		}
	}
	
	public static void merge(int[] arr,int start,int mid,int end){
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int cur = 0;
		while (i <= mid && j <= end){
			if (arr[i] < arr[j]){
				temp[cur++] = arr[i++];
			}else{
				temp[cur++] = arr[j++];
			}
		}
		while (i <= mid){
			temp[cur++] = arr[i++];
		}
		while (j <= end){
			temp[cur++] = arr[j++];
		}
		for (int k = 0 ;k < cur;k++){
			arr[start + k] = temp[k];
		}
	}
	
}