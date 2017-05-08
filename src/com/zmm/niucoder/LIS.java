import java.util.*;
/*
最长上升子序列
*/
public class LIS{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] input = new int[length];
		for (int i = 0 ;i < length;i++){
			input[i] = sc.nextInt();
		}
		int result = lis(input);
		System.out.println(result);
	}
	
	public static int lis(int[] arr){
		//dp数组中最长的索引，并不是最大数的索引
		int longest_index = 0;
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for (int i = 1 ;i < arr.length;i++){
			int len = 0;
			for (int j = 0 ;j < i;j++){
				if (arr[j] < arr[i] && dp[j] > len){
					len = dp[j];
				}
			}
			if (len == 0){
				dp[i] = dp[i - 1];
			}else{
				dp[i] = len + 1;
			}
		}
		return dp[dp.length - 1];
	}
	
}
