import java.util.*;

public class QuickSort{
	
	public static void main(String[] args){
		int[] input = new int[]{3,2,4,4,5,7,1,2,3,11,15,3,2,1};
		quickSort(input,0,input.length - 1);
		System.out.println(Arrays.toString(input));
	}
	//使用的均为索引
	public static void quickSort(int[] arr,int low,int high){
		if (high > low){
			int temp = partition(arr,low,high);
			quickSort(arr,low,temp - 1);
			quickSort(arr,temp + 1,high);
		}
	}
	
	public static int partition(int[] arr,int low,int high){
		int temp = arr[low];
		while (high > low){
			//标志位数字肯定在low or high之中,因此每次都是low和high互换
			//这里面也要判断high > low要不然全满足会一直减怎么办...
			while (high > low && arr[high] >= temp) high--;
			swap(arr,high,low);
			while (high > low && arr[low] <= temp) low++;
			swap(arr,low,high);
		}
		return low;
	}
	
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}