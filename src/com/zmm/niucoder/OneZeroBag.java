import java.util.*;
/*
0-1��������
*/
public class OneZeroBag{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int capcity = sc.nextInt();
		int[] w = new int[num];
		int[] v = new int[num];
		for (int i = 0 ;i < num;i++){
			v[i] = sc.nextInt();
		}
		for (int i = 0 ;i < num;i++){
			w[i] = sc.nextInt();
		}
		int result = solve(w,v,capcity);
		System.out.println(result);
	}
	//i -> value
	//j -> ���µ�weight
	//			 dp[i - 1][j] //�Ų���
	//dp[i][j] = 
	//			 Math.max(dp[i - 1][j],dp[i - 1][j - w[i]] + v[i]);
	//�ڲ������������ȡ�ϴ��,�ŵĻ�Ҫ�����µ�weight�м�ȥw[i]
	//w[]��v[]�ĳ��Ȳ�û��+1 so������Ҫ-1��
	public static int solve(int[] w,int[] v,int capcity){
		int[][] dp = new int[v.length + 1][capcity + 1];
		for (int i = 1 ;i < dp.length;i++){
			for (int j = 1;j < dp[0].length;j++){
				if (j < w[i - 1]){					
					dp[i][j] = dp[i - 1][j];
				}else{
					dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - w[i - 1]] + v[i - 1]);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
	
}